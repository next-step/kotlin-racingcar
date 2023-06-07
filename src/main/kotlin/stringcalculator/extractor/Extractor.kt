package stringcalculator.extractor

fun interface Extractor<T> {
    fun extract(items: List<String>): T
}
