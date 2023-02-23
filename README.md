# missing-interface
Simple web server looking for cause missing interface added by javaagent.

## requirements
jdk11+

## build
```
./gradlew shadowJar
```

## run
```
cd build/libs
java -jar missing-interface-1.0-SNAPSHOT-all.jar -Dport=7070
```

## service url

### /class-list
Display all loaded classes

### /interface-of/{className}
Show interfaces of passing className

ex) localhost:7070/interface-of/jakarta.servlet.http.HttpServletRequest
