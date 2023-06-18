package racingcar.view

class InputView : InputViewProtocol {

    private val inputValidator: InputValidator = InputValidator()

    private fun getCarInput(): String {
        val str = readLine()
        inputValidator.validate(str)
        return str.toString()
    }

    override fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carInfo = getCarInput()
        return carInfo.split(",")
    }

    override fun getRoundNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
