package racing

class ConsoleInputView : InputView {
    override fun askCarCount() {
        println("자동차 대수는 몇 대 인가요?")
    }

    override fun askTryCount() {
        println("시도할 회수는 몇 회 인가요?")
    }

    override fun inputCount(count: String?): Int {
        val input = validate(count)

        return convertToInt(input)
    }

    private fun validate(input: String?): String {
        requireNotNull(input) { "입력이 없습니다." }
        require(input.matches(Regex(NUMBER_REGEX))) { "0 ~ 9 사이의 숫자만 입력 가능합니다." }

        return input
    }

    private fun convertToInt(input: String): Int {
        return input.toInt()
    }

    companion object {
        const val NUMBER_REGEX = "^[0-9]$"
    }
}
