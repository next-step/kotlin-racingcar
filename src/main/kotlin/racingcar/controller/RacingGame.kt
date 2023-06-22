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

    val winners: List<Car>
        get() = cars.winners

    fun start(tryNum: Int) {
        repeat(tryNum) {
            cars.moveAllCars(conditionGenerator)
            ResultView().printResult(cars.namesAndPositions)
        }
        ResultView().printWinners(winners.map { it.carName.name })
    }
}
