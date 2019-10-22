package mu.robertiturnbull.kotlin.logging

import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class KotlinLoggerSlf4jTest {
    companion object : KotlinLogging()

    private val exampleException = Exception("Test Example Exception")

    @Test
    fun trace() {
        log.trace { "trace()" }
    }

    @Test
    fun testTrace() {
        log.trace(exampleException) { "testTrace()" }
    }

    @Test
    fun debug() {
        log.debug { "debug()" }
    }

    @Test
    fun testDebug() {
        log.debug(exampleException) { "testDebug()" }
    }

    @Test
    fun info() {
        log.info { "info()" }
    }

    @Test
    fun testInfo() {
        log.info(exampleException) { "testInfo()" }
    }

    @Test
    fun warn() {
        log.warn { "warn()" }
    }

    @Test
    fun testWarn() {
        log.warn(exampleException) { "testWarn()" }
    }

    @Test
    fun error() {
        log.error { "error()" }
    }

    @Test
    fun testError() {
        log.error(exampleException) { "testError()" }
    }

    @Test
    fun testKClassLogger() {
        val logger = KotlinLoggerSlf4j(BigDecimal::class)
        logger.warn { "testKClassLogger(BigDecimal::class)" }
    }

    @Test
    fun testClassLogger() {
        val logger = KotlinLoggerSlf4j(String::class.java)
        logger.warn { "testClassLogger(String::class.java)" }
    }

    @Test
    fun testCategoryLogger() {
        val logger = KotlinLoggerSlf4j("TestCategory")
        logger.warn { "testCategoryLogger(TestCategory)" }
    }

}