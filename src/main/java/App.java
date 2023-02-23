import com.google.common.reflect.ClassPath;
import io.javalin.Javalin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        int port = Integer.parseInt(System.getProperty("port", "7070"));
        Javalin app = Javalin.create()
            .get("/", ctx -> ctx.result("Hello World"))
            .get("/class-list", ctx -> {
                ClassPath classPath = ClassPath.from(App.class.getClassLoader());
                ctx.result(String.join("\n", classPath.getAllClasses().stream().map(classInfo -> classInfo.getName()).collect(Collectors.toList())));
            })
            .get("/interface-of/{className}", ctx -> {
                String className = ctx.pathParam("className");
                ctx.result(Arrays.toString(Class.forName(className).getInterfaces()));
            })
            .start(port);
    }
}
