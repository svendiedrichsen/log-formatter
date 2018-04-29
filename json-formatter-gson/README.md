## JSON log formatter using [GSON](https://github.com/google/gson)

### Usage
Configure to use it as a formatter for a JUL FileHandler
```
...
java.util.logging.FileHandler.formatter=logging.util.json.GsonFormatter
...
```

### Maven regular dependency
```
<dependency>
    <artifactId>json-formatter-gson</artifactId>
    <groupId>logging.util</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Maven uber dependency
```
<dependency>
    <artifactId>json-formatter-gson</artifactId>
    <groupId>logging.util</groupId>
    <version>1.0-SNAPSHOT</version>
    <classifier>uber</classifier>
</dependency>
```
