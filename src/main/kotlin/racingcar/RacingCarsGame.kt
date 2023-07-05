package racingcar

object RacingCarsGame {
    fun startGame(racingCars: RacingCars, numberOfGameRun: Int) {
        for (i in 0 until numberOfGameRun) {
            racingCars.runCars()
            RacingCarView.printCarsPosition(racingCars.getCars())
        }
    }
}

fun main() {
    RacingCarView.printCarsInputView()
    val inputString = readln()
    val cars = StringParser.parseRacingCarString(inputString)
    val racingCars = RacingCars.of(cars)
    RacingCarView.printAttemptInputView()
    val attemptNumber = StringParser.getIntValue(readln())
    RacingCarView.printResultView()
    RacingCarsGame.startGame(racingCars, attemptNumber)
    val winners = Winners(racingCars.getCars())
    RacingCarView.printWinnerCars(winners.cars)
}
