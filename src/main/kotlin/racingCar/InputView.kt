package racingCar

object InputView {
    private val NUMBER_REGEX = Regex("\\d+")

    fun inputAmountOfPlayer(): Int {
        println("자동차 대수는 몇 대인가요?")
        val number = readLine()!!
        validateInteger(number)
        return number.toInt()
    }

    private fun validateInteger(number: String) {
        if (!number.matches(NUMBER_REGEX)) {
            throw NotSupportedTypeException("숫자나 정수만 입력해주세요.")
        }
    }
}
