package racingcar.view.input.validator

class IntInputValidator(private val range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE) : InputValidator<Int> {

    companion object {
        private const val ERROR_MESSAGE_NO_NUMBER = "숫자로 입력해 주세요."
    }

    constructor(greaterThan: Int) : this((greaterThan + 1)..Int.MAX_VALUE)

    override fun parseValue(inputString: String?): Int {
        return try {
            val intValue = inputString?.toInt() ?: throw Exception(ERROR_MESSAGE_NO_NUMBER)
            checkValueInRange(intValue)
        } catch (e: NumberFormatException) {
            throw Exception(ERROR_MESSAGE_NO_NUMBER)
        }
    }

    private fun checkValueInRange(value: Int): Int {
        val range = this.range
        if (value in range) {
            return value // OK, value in the range
        }
        throw Exception(makeErrorMessage(range))
    }

    private fun makeErrorMessage(range: IntRange): String {
        return if (range.last == Int.MAX_VALUE) {
            "${range.first - 1} 보다 큰 값을 입력해 주세요. "
        } else {
            "${range.first}와 ${range.last} 사이 값을 입력해 주세요."
        }
    }
}
