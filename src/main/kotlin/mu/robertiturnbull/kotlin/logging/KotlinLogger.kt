package mu.robertiturnbull.kotlin.logging

interface KotlinLogger {
    fun trace(marker: String? = null, message: () -> Any?)
    fun trace(throwable: Throwable, marker: String? = null, message: () -> Any? = { null })
    fun debug(marker: String? = null, message: () -> Any?)
    fun debug(throwable: Throwable, marker: String? = null, message: () -> Any? = { null })
    fun info(marker: String? = null, message: () -> Any?)
    fun info(throwable: Throwable, marker: String? = null, message: () -> Any? = { null })
    fun warn(marker: String? = null, message: () -> Any?)
    fun warn(throwable: Throwable, marker: String? = null, message: () -> Any? = { null })
    fun error(marker: String? = null, message: () -> Any?)
    fun error(throwable: Throwable, marker: String? = null, message: () -> Any? = { null })
}