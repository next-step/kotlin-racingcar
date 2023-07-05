package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.ResultView

class RacingGame(
    private val cars: Cars,
) {
    private val winners: List<Car>
        get() = cars.winners

    val countWinners: Int
        get() = winners.size

    fun start(tryNum: Int) {
        (1..tryNum).map {
            cars.moveAllCars()
            ResultView().makeResultString(cars.namesAndPositions)
        }.joinToString("\n\n")
            .run {
                println(this + "\n")
            }

        ResultView().printWinners(winners.map { it.carName.name })
    }
}
