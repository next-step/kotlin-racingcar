package view

import manager.CarManager

class InputView(private val carManager: CarManager) {

    fun inputCarsWithName(inputFunction: () -> String) {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        var input = inputFunction.invoke()
        var driverList = input.split(DELIMETER)
        carManager.addDrivers(driverList)
    }

    fun inputTryMoveCount(inputFunction: () -> String) {
        println("시도할 횟수는 몇 회인가요?")
        var input = inputFunction.invoke()
        checkRegexNumber(input)
        carManager.setTryCount(input.toInt())
        carManager.tryMoving()
    }

    private fun checkRegexNumber(input: String) {
        if (!VALID_REGEX.matches(input)) {
            throw IllegalArgumentException("only input number please")
        }
    }

    companion object {
        val DELIMETER = ","
        val VALID_REGEX = Regex(pattern = "^[0-9]+$")
    }
}
