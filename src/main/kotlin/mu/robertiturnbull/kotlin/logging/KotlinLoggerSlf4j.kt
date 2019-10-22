package mu.robertiturnbull.kotlin.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

class KotlinLoggerSlf4j(private val logger: Logger) : KotlinLogger {

    constructor(clazz: KClass<*>) : this(LoggerFactory.getLogger(clazz.java))
    constructor(clazz: Class<*>) : this(LoggerFactory.getLogger(clazz))
    constructor(category: String) : this(LoggerFactory.getLogger(category))

    override fun trace(message: () -> Any?) {
        if (logger.isTraceEnabled) {
            logger.trace(handle(message))
        }
    }

    override fun trace(throwable: Throwable, message: () -> Any?) {
        if (logger.isTraceEnabled) {
            logger.trace(handle(message) ?: throwable.message, throwable)
        }
    }

    override fun debug(message: () -> Any?) {
        if (logger.isDebugEnabled) {
            logger.debug(handle(message))
        }
    }

    override fun debug(throwable: Throwable, message: () -> Any?) {
        if (logger.isDebugEnabled) {
            logger.debug(handle(message) ?: throwable.message, throwable)
        }
    }

    override fun info(message: () -> Any?) {
        if (logger.isInfoEnabled) {
            logger.info(handle(message))
        }
    }

    override fun info(throwable: Throwable, message: () -> Any?) {
        if (logger.isInfoEnabled) {
            logger.info(handle(message) ?: throwable.message, throwable)
        }
    }

    override fun warn(message: () -> Any?) {
        if (logger.isWarnEnabled) {
            logger.warn(handle(message))
        }
    }

    override fun warn(throwable: Throwable, message: () -> Any?) {
        if (logger.isWarnEnabled) {
            logger.warn(handle(message) ?: throwable.message, throwable)
        }
    }

    override fun error(message: () -> Any?) {
        if (logger.isErrorEnabled) {
            logger.error(handle(message))
        }
    }

    override fun error(throwable: Throwable, message: () -> Any?) {
        if (logger.isErrorEnabled) {
            logger.error(handle(message) ?: throwable.message, throwable)
        }
    }

    private fun handle(message: () -> Any?): String? = message()?.toString()

}