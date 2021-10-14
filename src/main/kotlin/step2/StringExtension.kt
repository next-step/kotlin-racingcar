package step2

fun String?.toArithmeticSymbolOrNull(): String? {
    val arithmeticsSymbols = listOf("+", "-", "*", "/")

    if (arithmeticsSymbols.contains(this)) {
        return this
    }

    return null
}
