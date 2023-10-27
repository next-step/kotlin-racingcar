package study.racing.domain

import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Cars private constructor(
    private var cars: List<Car>,
    private val strategy: MoveStrategy
) {

    constructor(cars: List<Car>) : this(cars, RandomMoveStrategy())

    fun moveTheCars() {
        cars.forEach { car ->
            car.tryMoveTheCar(strategy.isMoving())
        }
    }

    fun getCarsMoveDistance(): List<Int> = this.cars.map {
        it.getCarDistance()
    }.toList()

    companion object {
        fun from(
            carCount: Int
        ): Cars {

            validationCarCount(carCount)

            return Cars(
                createCountOfCars(carCount)
            )
        }

        fun of(
            carCount: Int,
            strategy: MoveStrategy
        ): Cars {

            validationCarCount(carCount)

            return Cars(
                createCountOfCars(carCount),
                strategy
            )
        }

        private fun createCountOfCars(carCount: Int): MutableList<Car> {
            val cars = mutableListOf<Car>()
            repeat(carCount) {
                cars.add(Car())
            }
            return cars
        }

        private fun validationCarCount(carCount: Int) {
            require(carCount > 0) {
                "차량은 최소 1대 이상 요청해 주세요."
            }
        }
    }
}
