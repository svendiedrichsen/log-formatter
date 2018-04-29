## JSON log formatter using [Jackson2](https://github.com/FasterXML/jackson)

### Usage
Configure to use it as a formatter for a JUL FileHandler
```
...
java.util.logging.FileHandler.formatter=logging.util.json.Jackson2Formatter
...
```

### Maven regular dependency
```
<dependency>
    <artifactId>json-formatter-jackson2</artifactId>
    <groupId>logging.util</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Maven uber dependency
```
<dependency>
    <artifactId>json-formatter-jackson2</artifactId>
    <groupId>logging.util</groupId>
    <version>1.0-SNAPSHOT</version>
    <classifier>uber</classifier>
</dependency>
```
