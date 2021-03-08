package calculator

import java.lang.IllegalArgumentException

class Calculator(private val input: String?) {
    init {
        require(!input.isNullOrBlank()) { "input value is null or blank." }
    }

    private val elements: List<String>
        get() = input!!.split(delimiter)

    fun getResult(): Int {
        if (elements.first().toIntOrNull() == null) {
            throw IllegalArgumentException("start element is not number.")
        }

        if (elements.last().toIntOrNull() == null) {
            throw IllegalArgumentException("end element is not number.")
        }

        return elements
            .fold(0 to Operator.PLUS) { accumulator, element ->
                operate(accumulator, element)
            }
            .first
    }

    private fun operate(accumulator: Pair<Int, Operator>, element: String): Pair<Int, Operator> {
        if (Operator.contain(element)) {
            return accumulator.first to Operator.bySign(element)
        }

        val result = accumulator.second.operator(
            accumulator.first,
            element.toIntOrNull() ?: throw IllegalArgumentException("$element is illegal value.")
        )
        return result to Operator.PLUS
    }

    companion object {
        const val delimiter: String = " "
    }
}
