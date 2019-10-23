package mu.robertiturnbull.kotlin.logging

interface Mdc {
    fun saveMdcEntry(key: String, value: Any?)
    fun loadMdcEntry(key: String): String?
    fun removeMdcEntry(key: String)
    fun clearMdc()
}