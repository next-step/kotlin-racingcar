package racingcar.model

import racingcar.strategy.MoveStrategy
import racingcar.view.ResultView

class Cars private constructor(private val allCars: List<Car>) {
    companion object {
        fun makeCars(carNames: List<String>): Cars {
            val cars = carNames
                .map { carName -> Car(carName) }

            return Cars(cars)
        }
    }

    fun moveOnce(moveStrategy: MoveStrategy): List<ResultView> {
        return allCars
            .map { car ->
                car.move(moveStrategy.canMove())
                return@map ResultView(car)
            }
    }

    fun getNumberOfCars(): Int {
        return allCars.size
    }

    fun findMaxScore(): Int? {
        return allCars
            .map { it.score }
            .max()
            ?.toInt()
    }

    fun findWinners(): List<Car> {
        val maxScore = findMaxScore()
        return allCars
            .filter { it.score == maxScore }
    }
}
