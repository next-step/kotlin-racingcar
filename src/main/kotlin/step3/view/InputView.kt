package step3.view

import step3.model.RacingGame

class InputView {
    fun receiveUserInput() = RacingGame(
        receiveNumberOfCars(),
        receiveNumberOfAttempts()
    )

    private fun receiveNumberOfCars(): Int {
        println(INPUT_MESSAGE_NUMBER_OF_CARS)
        val inputNumberOfCars = requireNotNull(readLine())
        return inputNumberOfCars.toInt()
    }

    private fun receiveNumberOfAttempts(): Int {
        println(INPUT_MESSAGE_NUMBER_OF_ATTEMPTS)
        val inputNumberOfAttempts = requireNotNull(readLine())
        return inputNumberOfAttempts.toInt()
    }

    companion object {
        private const val INPUT_MESSAGE_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?"
        private const val INPUT_MESSAGE_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
    }
}