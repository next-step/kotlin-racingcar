package racingcar.model

import racingcar.strategy.MoveStrategy

class Cars private constructor(private val allCars: List<Car>) {
    companion object {
        fun makeCars(carNames: List<String>): Cars {
            val cars = carNames
                .map { carName -> Car(carName) }

            return Cars(cars)
        }
    }

    fun moveOnce(moveStrategy: MoveStrategy): List<Car> {
        allCars.forEach { it.move(moveStrategy.canMove()) }
        return allCars
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
