package racingcar

import racingcar.domain.Cars
import racingcar.domain.Count
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.view.OutputView.Companion.printRaceResults

fun main() {
    playRacingCar()
}

private fun playRacingCar() {
    val names = InputView.inputCarNames()
    val cars = Cars.register(names)
    val count = Count(InputView.inputCounts())
    race(count, cars)
}

private fun race(count: Count, cars: Cars) {
    println(OutputView.GAME_RESULT_MESSAGE)
    repeat(count.value) {
        val raceResults = cars.race()
        printRaceResults(raceResults)
    }
    val racingWinners = cars.findRacingWinners()
}
