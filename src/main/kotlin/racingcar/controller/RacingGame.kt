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
        repeat(tryNum) {
            cars.moveAllCars(conditionGenerator)
            ResultView().printResult(cars.namesAndPositions)
        }
        ResultView().printWinners(winners.map { it.carName.name })
    }
}
