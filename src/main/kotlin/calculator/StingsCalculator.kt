package calculator

import calculator.Operation.Companion.numberOperation

internal class StingsCalculator(strings: List<String>) {

    private val strings: List<String> = strings.toList()

    init {
        require(strings.none { it.isBlank() }) { "calculated strings must not be blank. strings(`$strings`)" }
        require(strings.isOddSize) { "calculated strings must be odd size. strings(`$strings`)" }
    }

    val number: Int
        get() = strings.iterator().let {
            var result: Int = it.next().toInt()
            while (it.hasNext()) {
                val operation: Operation = it.next().numberOperation
                val nextNumber: Int = it.next().toInt()
                result = operation.calculate(result, nextNumber)
            }
            result
        }

    companion object {
        private val Collection<Any>.isOddSize: Boolean
            get() = size % 2 == 1
    }
}
