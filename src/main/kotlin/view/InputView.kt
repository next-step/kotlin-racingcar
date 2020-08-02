package view

class InputView() {

    fun inputCarsWithName(inputFunction: () -> String): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return inputFunction().split(DELIMETER)
    }

    fun inputTryMoveCount(inputFunction: () -> String): Int {
        println("시도할 횟수는 몇 회인가요?")
        var input = inputFunction()
        checkRegexNumber(input)
        return input.toInt()
    }

    private fun checkRegexNumber(input: String) {
        if (!VALID_REGEX.matches(input)) {
            throw IllegalArgumentException("only input number please")
        }
    }

    companion object {
        const val DELIMETER = ","
        val VALID_REGEX = Regex(pattern = "^[0-9]+$")
    }
}
