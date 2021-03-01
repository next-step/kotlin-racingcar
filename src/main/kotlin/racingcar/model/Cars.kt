package racingcar.model

import racingcar.strategy.MoveStrategy
import racingcar.view.ResultView

class Cars private constructor(private val allCars: List<Car>) {
    companion object {
        fun makeCars(carNames: List<String>): Cars {

            val cars = carNames
                .asSequence()
                .map { carName: String -> Car(carName) }
                .toList()

            return Cars(cars as ArrayList<Car>)
        }
    }

    fun moveOnce(moveStrategy: MoveStrategy): List<ResultView> {
        return allCars.asSequence()
            .map { car: Car ->
                car.move(moveStrategy.canMove())
                return@map ResultView(car)
            }
            .toList()
    }

    fun getNumberOfCars(): Int {
        return allCars.size
    }

    fun findMaxScore(): Int? {
        return allCars.asSequence()
            .map { car -> car.score }
            .max()
            ?.toInt()
    }

    fun findWinners(): List<Car> {
        val maxScore = findMaxScore()
        return allCars.asSequence()
            .filter { car -> car.score == maxScore }
            .toList()
    }
}
