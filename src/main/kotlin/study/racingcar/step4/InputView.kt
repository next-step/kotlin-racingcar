package study.racingcar.step4

class InputView {

    private val SEPARATOR_COMMA = ","
    private val inputValidation = InputValidation()

    fun inputCarNameList(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNameList = readLine()?.split(SEPARATOR_COMMA) ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
        inputValidation.validationCarNameLength(carNameList)
        return carNameList
    }

    fun inputRunCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }
}
