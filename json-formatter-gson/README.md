## JSON log formatter using [GSON](https://github.com/google/gson)

### Usage
Configure to use it as a formatter for a JUL FileHandler
```
...
java.util.logging.FileHandler.formatter=logging.util.json.GsonFormatter
...
```

### Maven dependency
```
<dependency>
    <artifactId>json-formatter-gson</artifactId>
    <groupId>com.github.svendiedrichsen</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
To use the uber dependency add the maven `<classifier>uber</classifier>`.
