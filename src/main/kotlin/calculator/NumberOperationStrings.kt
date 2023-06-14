package calculator

internal class NumberOperationStrings(strings: List<String>) {

    private val strings: List<String> = strings.toList()

    init {
        require(strings.none { it.isBlank() }) { "calculated strings must not be blank. strings(`$strings`)" }
        require(isOddSize(strings)) { "calculated strings must be odd size. strings(`$strings`)" }
    }

    val calculatedNumber: Int
        get() = strings.iterator().let {
            var result: Int = it.next().toInt()
            while (it.hasNext()) {
                val operation: Operation = Operation.signOf(it.next())
                val nextNumber: Int = it.next().toInt()
                result = operation.calculate(result, nextNumber)
            }
            result
        }

    companion object {
        private fun <T> isOddSize(target: Collection<T>): Boolean {
            return target.size % 2 == 1
        }
    }
}
