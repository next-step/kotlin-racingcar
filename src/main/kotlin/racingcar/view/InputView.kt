package racingcar.view

import racingcar.validator.InputValidator

object InputView {
    private const val COMMA = ','
    private val inputValidator = InputValidator()

    fun getNameOfCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readLine()
        return inputValidator.inputValidate(input).split(COMMA)
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = inputValidator.inputValidate(readLine())
        return inputValidator.numberValidate(input)
    }
}
