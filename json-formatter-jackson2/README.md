## JSON log formatter using [Jackson2](https://github.com/FasterXML/jackson)

### Usage
Configure to use it as a formatter for a JUL FileHandler
```
...
java.util.logging.FileHandler.formatter=logging.util.json.Jackson2Formatter
...
```

### Maven dependency
```
<dependency>
    <artifactId>json-formatter-jackson2</artifactId>
    <groupId>com.github.svendiedrichsen</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
To use the uber dependency add the maven `<classifier>uber</classifier>`.
