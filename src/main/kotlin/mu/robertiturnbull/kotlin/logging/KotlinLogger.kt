package mu.robertiturnbull.kotlin.logging

interface KotlinLogger {
    fun trace(message: () -> Any?)
    fun trace(throwable: Throwable, message: () -> Any? = { null })
    fun debug(message: () -> Any?)
    fun debug(throwable: Throwable, message: () -> Any? = { null })
    fun info(message: () -> Any?)
    fun info(throwable: Throwable, message: () -> Any? = { null })
    fun warn(message: () -> Any?)
    fun warn(throwable: Throwable, message: () -> Any? = { null })
    fun error(message: () -> Any?)
    fun error(throwable: Throwable, message: () -> Any? = { null })
}