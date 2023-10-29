package study.racing.domain

import study.racing.strategy.MoveStrategy

class Cars private constructor(
    private val cars: List<Car> = listOf(),
) {

    init {
        require(cars.isNotEmpty()) {
            "차량은 최소 1대 이상 요청해 주세요."
        }
    }

    fun moveTheCars() {
        cars.forEach { car ->
            car.tryMoveTheCar()
        }
    }

    fun getCarsMoveDistance(): List<Int> = this.cars.map {
        it.getCarDistance()
    }.toList()

    companion object {
        fun from(
            carCount: Int
        ): Cars {
            return Cars(
                createCountOfCars(carCount)
            )
        }

        fun of(
            carCount: Int,
            strategy: MoveStrategy
        ): Cars {
            return Cars(
                createCountOfCars(carCount, strategy),
            )
        }

        private fun createCountOfCars(carCount: Int): List<Car> = List(carCount) { Car() }
        private fun createCountOfCars(carCount: Int, strategy: MoveStrategy): List<Car> =
            List(carCount) { Car(strategy) }
    }
}
