package mu.robertiturnbull.kotlin.logging

abstract class KotlinLogging {
    companion object {
        @JvmStatic
        protected val mdc = MdcSlf4j()
    }

    protected val log: KotlinLogger = KotlinLoggerSlf4j(this::class.java.enclosingClass)
    protected fun mdc(): Mdc = mdc
}