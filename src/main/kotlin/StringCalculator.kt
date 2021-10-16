import ExceptionCase.Companion.CASE_INCORRECT_INPUT
import ExceptionCase.Companion.CASE_INPUT_NULL_OR_EMPTY
import ExceptionCase.Companion.CASE_INT_FORMAT_OR_NULL

/**
 * 사측연산 계산 class
 * */
class StringCalculator {
    private val delimiter = " "

    fun calculate(input: String?): Int? {
        require(!input.isNullOrBlank()) { CASE_INPUT_NULL_OR_EMPTY }
        val list = input.split(delimiter)
        if (list.size % 2 == 0) throw IllegalArgumentException(CASE_INCORRECT_INPUT)

        val totalCalculateCount = list.size / 2
        var result: Int? = null
        for (i in 1..totalCalculateCount) {
            result = OperatorSymbol.convertSymbol(list[i * 2 - 1])
                .operator(result ?: list[0].toIntOrException(), list[i * 2].toIntOrException())
        }
        return result
    }

    private fun String.toIntOrException(): Int =
        toIntOrNull() ?: throw IllegalArgumentException(CASE_INT_FORMAT_OR_NULL)
}
