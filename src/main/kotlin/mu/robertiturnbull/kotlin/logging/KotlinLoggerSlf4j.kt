package mu.robertiturnbull.kotlin.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.Marker
import org.slf4j.MarkerFactory
import kotlin.reflect.KClass

class KotlinLoggerSlf4j(private val logger: Logger) : KotlinLogger {

    constructor(clazz: KClass<*>) : this(LoggerFactory.getLogger(clazz.java))
    constructor(clazz: Class<*>) : this(LoggerFactory.getLogger(clazz))
    constructor(category: String) : this(LoggerFactory.getLogger(category))

    override fun trace(marker: String?, message: () -> Any?) {
        if (logger.isTraceEnabled) {
            logger.trace(marker(marker), handle(message))
        }
    }

    override fun trace(throwable: Throwable, marker: String?, message: () -> Any?) {
        if (logger.isTraceEnabled) {
            logger.trace(marker(marker), handle(message) ?: throwable.message, throwable)
        }
    }

    override fun debug(marker: String?, message: () -> Any?) {
        if (logger.isDebugEnabled) {
            logger.debug(marker(marker), handle(message))
        }
    }

    override fun debug(throwable: Throwable, marker: String?, message: () -> Any?) {
        if (logger.isDebugEnabled) {
            logger.debug(marker(marker), handle(message) ?: throwable.message, throwable)
        }
    }

    override fun info(marker: String?, message: () -> Any?) {
        if (logger.isInfoEnabled) {
            logger.info(marker(marker), handle(message))
        }
    }

    override fun info(throwable: Throwable, marker: String?, message: () -> Any?) {
        if (logger.isInfoEnabled) {
            logger.info(marker(marker), handle(message) ?: throwable.message, throwable)
        }
    }

    override fun warn(marker: String?, message: () -> Any?) {
        if (logger.isWarnEnabled) {
            logger.warn(marker(marker), handle(message))
        }
    }

    override fun warn(throwable: Throwable, marker: String?, message: () -> Any?) {
        if (logger.isWarnEnabled) {
            logger.warn(marker(marker), handle(message) ?: throwable.message, throwable)
        }
    }

    override fun error(marker: String?, message: () -> Any?) {
        if (logger.isErrorEnabled) {
            logger.error(marker(marker), handle(message))
        }
    }

    override fun error(throwable: Throwable, marker: String?, message: () -> Any?) {
        if (logger.isErrorEnabled) {
            logger.error(marker(marker), handle(message) ?: throwable.message, throwable)
        }
    }

    ///

    private fun handle(message: () -> Any?): String? = message()?.toString()
    private fun marker(marker: String?): Marker? = marker?.let { MarkerFactory.getMarker(marker) }

}