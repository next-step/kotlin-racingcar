package racing.ui

import racing.model.CarInput

class InputView {
    fun getInput(): CarInput {
        val carInput = CarInput()
        carInput.carCount = getNumberOfCars()
        carInput.times = getNumberOfTimes()

        println()
        return carInput
    }

    private fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        val count = readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid Input(cars)")

        require(count > 0) { "Number of cars > 0" }
        return count
    }

    private fun getNumberOfTimes(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid Input(times)")
    }
}
