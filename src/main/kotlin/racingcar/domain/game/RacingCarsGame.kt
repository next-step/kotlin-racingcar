package racingcar.domain.game

import racingcar.domain.car.RacingCars
import racingcar.domain.car.Winners
import racingcar.util.StringParser
import racingcar.view.RacingCarView

object RacingCarsGame {
    fun startGame(racingCars: RacingCars, numberOfGameRun: Int) {
        repeat(numberOfGameRun) {
            racingCars.runCars()
            RacingCarView.printCarsPosition(racingCars.cars)
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
    val winners = Winners(racingCars.cars)
    RacingCarView.printWinnerCars(winners.cars)
}
