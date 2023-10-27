package calculator.model

import calculator.exception.ErrorMessages.INVALID_NUMBER_INPUT_EXCEPTION

data class Numbers(
    val numbers: List<Int>
) {
    fun first(): Int {
        return numbers.first()
    }

    fun size(): Int {
        return numbers.size
    }

    fun getNumbersExcludingFirst(): List<Int> {
        return numbers.drop(1).toList()
    }

    companion object {
        fun of(inputs: List<String>): Numbers {
            return Numbers(inputs.map { validateNumber(it) }.toList())
        }

        private fun validateNumber(input: String): Int {
            return try {
                input.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(INVALID_NUMBER_INPUT_EXCEPTION.message)
            }
        }
    }
}
