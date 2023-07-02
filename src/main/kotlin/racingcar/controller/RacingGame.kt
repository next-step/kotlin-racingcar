package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.ConditionGenerator
import racingcar.domain.RandomConditionGenerator
import racingcar.view.ResultView

class RacingGame(
    carNames: List<String>,
    private val conditionGenerator: ConditionGenerator = RandomConditionGenerator(),
) {
    private val cars: Cars = Cars(carNames)

    private val winners: List<Car>
        get() = cars.winners

    val countWinners: Int
        get() = winners.size

    fun start(tryNum: Int) {
        (1..tryNum).map {
            cars.moveAllCars(conditionGenerator)
            ResultView().makeResultString(cars.namesAndPositions)
        }.joinToString("\n\n")
            .run {
                println(this + "\n")
            }

        ResultView().printWinners(winners.map { it.carName.name })
    }
}
