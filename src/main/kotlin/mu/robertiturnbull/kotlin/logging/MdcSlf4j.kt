package mu.robertiturnbull.kotlin.logging

import org.slf4j.MDC

class MdcSlf4j : Mdc {

    override fun saveMdcEntry(key: String, value: Any?) {
        MDC.put(key, value?.toString())
    }

    override fun loadMdcEntry(key: String): String? {
        return MDC.get(key)
    }

    override fun removeMdcEntry(key: String) {
        MDC.remove(key)
    }

    override fun clearMdc() {
        MDC.clear()
    }

}