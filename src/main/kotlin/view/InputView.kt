package view

import manager.CarManager

class InputView {
    val carManager: CarManager

    constructor(carManager: CarManager) {
        this.carManager = carManager
    }

    fun inputCarCount(input: String) {
        println("자동차 대수는 몇 대인가요?")
        if (!VALID_REGEX.matches(input)) {
            throw IllegalArgumentException("only input number please")
        }
        carsAdd(input.toInt())
    }

    fun inputTryMoveCount(input: String) {
        println("시도할 횟수는 몇 회인가요?")
        if (!VALID_REGEX.matches(input)) {
            throw IllegalArgumentException("only input number please")
        }
        tryMoving(input.toInt())
    }

    fun carsAdd(carCount: Int) {
        repeat(carCount) { carManager.add() }
    }

    fun tryMoving(tryCount: Int) {
        carManager.tryCount = tryCount
        repeat(tryCount) { carManager.move() }
    }

    companion object {
        val VALID_REGEX = Regex(pattern = "^[0-9]+$")
    }
}
