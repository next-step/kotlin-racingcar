package step3_racingcar.view

import step3_racingcar.validator.InputValidator

class InputView {
    private val inputValidator = InputValidator()

    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return inputValidator.inputValidate(readLine())
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return inputValidator.inputValidate(readLine())
    }
}
