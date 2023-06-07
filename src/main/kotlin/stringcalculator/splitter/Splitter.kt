package stringcalculator.splitter

fun interface Splitter<T> {
    fun split(input: String?): List<T>
}
