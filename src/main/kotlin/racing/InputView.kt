package racing

import java.util.regex.Pattern

class InputView(var number: Int = 0, var attempt: Int = 0) {

    private val NON_NUMERIC_REGEX = Pattern.compile("[^0-9]")

    companion object {
        const val DATA_IS_BLANK = "값이 비어있습니다"
        const val IS_POSSIBLE_NUMERIC = "숫자만 입력 가능합니다"
        const val NUMBER_REQUIRE_OVER_ONE = "자동차 개수는 1이상의 값을 요구합니다"
    }

    fun input(): InputView {
        println("자동차 수를 입력하세요")
        val number = readLine()

        println("이동 횟수를 입력하세요")
        val attempt = readLine()

        validate(number, attempt)

        return InputView(number!!.toInt(), attempt!!.toInt())
    }

    fun validate(number: String?, attempt: String?) {
        if (number.isNullOrBlank() || attempt.isNullOrBlank()) {
            throw IllegalArgumentException(DATA_IS_BLANK)
        }
        if (NON_NUMERIC_REGEX.matcher(number).matches() || NON_NUMERIC_REGEX.matcher(attempt).matches()) {
            throw IllegalArgumentException(IS_POSSIBLE_NUMERIC)
        }
        if (number.toInt() < 1) {
            throw IllegalArgumentException(NUMBER_REQUIRE_OVER_ONE)
        }
    }
}
