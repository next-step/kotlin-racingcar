package racingcar

class ConsoleInputView : InputView {
    companion object {
        private const val RECEIVE_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val RECEIVE_NUMBER_OF_TRIALS_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }

    override fun getNumberOfCars(): NumberOfCars {
        println(RECEIVE_NUMBER_OF_CARS_MESSAGE)
        return NumberOfCars(readLine()?.toIntOrNull())
    }

    override fun getNumberOfTrials(): NumberOfTrials {
        println(RECEIVE_NUMBER_OF_TRIALS_MESSAGE)
        return NumberOfTrials(readLine()?.toIntOrNull())
    }
}
