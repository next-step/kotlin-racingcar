package calculator

class ExpressionParser {
    companion object {
        fun <T> Iterable<String>.parse(filterByIndex: (Int) -> Boolean, convertByType: (String) -> T): List<T> {
            return this.withIndex()
                .filter { filterByIndex(it.index) }
                .map { convertByType(it.value) }
                .toList()
        }
    }
}
