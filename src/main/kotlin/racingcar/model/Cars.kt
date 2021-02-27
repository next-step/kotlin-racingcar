package racingcar.model

import racingcar.model.strategy.Strategy
import racingcar.view.ResultView

class Cars private constructor(private val allCars: ArrayList<Car>) {
    companion object {
        fun makeCars(numOfCars: Int): Cars {
            var cars = ArrayList<Car>()
            for (i in 1..numOfCars) {
                cars.add(Car())
            }

            return Cars(cars)
        }
    }

    fun moveOnce(strategy: Strategy): List<ResultView> {
        return allCars.asSequence()
            .map { car: Car ->
                car.move(strategy.canMove())
                return@map ResultView(car.getScore())
            }
            .toList()
    }

    fun getNumberOfCars(): Int {
        return allCars.size
    }

    fun getCarCountWithScoreEqualOrGreaterThan(score: Int): Int {
        return allCars.asSequence()
            .filter { car -> car.getScore() >= score }
            .count()
    }
}
