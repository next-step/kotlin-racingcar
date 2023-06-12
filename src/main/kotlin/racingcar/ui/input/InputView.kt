package racingcar.ui.input

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

    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",")
    }
}
