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
    fun debug(marker: String? = null, message: () -> Any?)
    fun debug(throwable: Throwable, marker: String? = null, message: () -> Any? = { null })
```
Example
```kotlin
    fun debug() {
        log.debug { "debugNormal()" }
        log.debug(ex)
        log.debug(ex) { "debugException()" }
    }
```
Example With Marker
```kotlin
    fun debug() {
        log.debug("MARKER") { "debugNormal()" }
        log.debug(ex, "MARKER")
        log.debug(ex, "MARKER") { "debugException()" }
    }
```
```
[%marker]
```
### Using MDC
Signature for MDC
```kotlin
    fun saveMdcEntry(key: String, value: Any?)
    fun loadMdcEntry(key: String): String?
    fun removeMdcEntry(key: String)
    fun clearMdc()
```
Example MDC usage
```kotlin
    fun setUpMdc() {
        mdc().saveMdcEntry("x-parent", parent)
        mdc().saveMdcEntry("x-child", child)
    }
```
```
[%X{x-parent},%X{x-child}]
```
