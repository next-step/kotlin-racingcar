package racingcar

import racingcar.domain.Cars
import racingcar.domain.Count
import racingcar.domain.Number
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.view.OutputView.Companion.printRaceResults

fun main() {
    playRacingCar()
}

private fun playRacingCar() {
    val number = Number(InputView.inputCars())
    val cars = Cars(number)
    val count = Count(InputView.inputCounts())
    race(count, cars)
}

private fun race(count: Count, cars: Cars) {
    println(OutputView.GAME_RESULT_MESSAGE)
    for (i in 0 until count.value) {
        val raceResults = cars.race()
        printRaceResults(raceResults)
    }
}
