package racingcar.output

class OutputConsole : Output {
    override fun numberOfCarsMessage(): Unit = println(NUMBER_OF_CARS_INPUT_MESSAGE)
    override fun tryTimesOfRace(): Unit = println(TRY_TIMES_OF_RACE_INPUT_MESSAGE)
    override fun positionOfCar(currentPosition: Int) {
        repeat((START_POSITION..currentPosition).count()) {
            print(CAR_POSITION_MARK)
        }
        println()
    }
    override fun emptyLine() {
        println()
    }

    companion object {
        private const val NUMBER_OF_CARS_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val TRY_TIMES_OF_RACE_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val CAR_POSITION_MARK = "-"
        private const val START_POSITION = 1
    }
}
