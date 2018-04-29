## Log formatter
This project contains `java.util.logging.Formatter` implementations usable with JUL logging. Each library
provides besides a normal JAR an Uber-Jar containing all required dependencies.

To use one of them you can set the formatter at the specific JUL `Handler` implementation. 

Each formatter adds a `timestamp` property to each log entry derived from the `LogRecord`s
`millis` property. It uses the RFC-3339 format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`.

### [JSON formatter using GSON](./json-formatter-gson/README.md)
Formatter using [GSON](https://github.com/google/gson) to create JSON.
  
### [JSON formatter using Jackson2](./json-formatter-jackson2/README.md)
Formatter using [Jackson2](https://github.com/FasterXML/jackson) to create JSON.
