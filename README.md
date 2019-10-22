# kotlin-logger
Idiomatic slf4j logging wrapper for kotlin projects.

## How to use
### Import
### Extend companion object
```kotlin
import mu.robertiturnbull.kotlin.logging.KotlinLogging
class <KotlinClass> {
    companion object : KotlinLogging()
}
```
### Use with string interpolation
Signature for .debug
```kotlin
    fun debug(message: () -> Any?)
    fun debug(throwable: Throwable, message: () -> Any? = { null })
```
Example
```kotlin
    fun debug() {
        log.debug { "debugNormal()" }
        log.debug(ex)
        log.debug(ex) { "debugException()" }
    }
```
