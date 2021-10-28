package racingcar.domain

import racingcar.domain.random.RandomGenerator
import racingcar.view.ResultView

class RacingCar(private val carList: List<Car>) {

    fun carAction(randomGenerator: RandomGenerator, resultView: ResultView) {
        carList.forEach { it.forward(randomGenerator.getIntRandom()) }
        resultView.action(carList)
        println()
    }

    fun victoryCar(): List<Car> {
        val max = carList.maxOf { it.distance }.or(0)
        return carList.filter { it.distance == max }.toList()
    }
}
