package racingCar.view

object InputView {
    private val NUMBER_REGEX = Regex("\\d+")

    fun inputAmountOfRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val number = readLine()!!
        validateInteger(number)
        return number.toInt()
    }

    fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readLine()!!
        validateNullOrEmpty(carNames)
        return carNames
    }

    private fun validateNullOrEmpty(value: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("빈 값이나 null은 입력할 수 없습니다.")
        }
    }

    private fun validateInteger(number: String) {
        if (!number.matches(NUMBER_REGEX)) {
            throw NotSupportedTypeException("숫자나 정수만 입력해주세요.")
        }
    }
}
