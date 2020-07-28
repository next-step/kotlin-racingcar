package view

import manager.CarManager

class InputView(private val carManager: CarManager) {

    fun inputCarCount(inputFunction: () -> String) {
        println("자동차 대수는 몇 대인가요?")
        var input = inputFunction.invoke()
        checkRegexNumber(input)
        carManager.setCarCount(input.toInt())
        carManager.carsAdd()
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
        val VALID_REGEX = Regex(pattern = "^[0-9]+$")
    }
}
