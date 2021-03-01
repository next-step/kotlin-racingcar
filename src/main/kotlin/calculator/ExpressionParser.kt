package calculator

class ExpressionParser {
    companion object {
        fun <T> Iterable<String>.parse(filterByIndex: (Int) -> Boolean, convertByType: (String) -> T): List<T> {
            return this.withIndex()
                .filterIndexed { index, _ -> filterByIndex(index) }
                .map { convertByType(it.value) }
                .toList()
        }
    }
}
