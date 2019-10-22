package mu.robertiturnbull.kotlin.logging

abstract class KotlinLogging {
    protected val log: KotlinLogger = KotlinLoggerSlf4j(this::class.java.enclosingClass)
}