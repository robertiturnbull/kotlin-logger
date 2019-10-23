package mu.robertiturnbull.kotlin.logging

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.*

class MdcExtension : BeforeAllCallback, BeforeEachCallback {
    companion object : KotlinLogging()

    private lateinit var parent: String

    override fun beforeAll(context: ExtensionContext?) {
        parent = random()
    }

    override fun beforeEach(context: ExtensionContext?) {
        val child = random()
        mdc().saveMdcEntry("x-parent", parent)
        mdc().saveMdcEntry("x-child", child)
    }

    private fun random(): String {
        return UUID.randomUUID().toString().substring(0..7)
    }

}