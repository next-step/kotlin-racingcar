package racingcar.model

import racingcar.strategy.MoveStrategy
import racingcar.view.ResultView

class Cars private constructor(private val allCars: ArrayList<Car>) {
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
                return@map ResultView(car.name, car.score)
            }
            .toList()
    }

    fun getNumberOfCars(): Int {
        return allCars.size
    }

    fun getCarCountWithScoreEqualOrGreaterThan(score: Int): Int {
        return allCars.asSequence()
            .filter { car -> car.score >= score }
            .count()
    }
}
