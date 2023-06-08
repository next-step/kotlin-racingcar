package racingcar.input

class InputView {
    private val inputValidator: InputValidator = InputValidator()

    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        val inputValue = readln().trim()
        require(inputValidator.isNumber(inputValue)) { "숫자를 입력해주세요" }
        return inputValue.toInt()
    }

    fun getNumberOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputValue = readln().trim()
        require(inputValidator.isNumber(inputValue)) { "숫자를 입력해주세요" }
        return inputValue.toInt()
    }
}
