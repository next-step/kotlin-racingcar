package racingcar.ui

class IntegerInputParser : InputParser<Int> {
    override fun parse(input: String): Int {
        return validate(input.toIntOrNull() ?: throw NumberFormatException("입력값이 정수가 아닙니다"))
    }

    private fun validate(input: Int): Int {
        require(input > 0) {
            "입력값은 1보다 커야 합니다"
        }
        return input
    }
}