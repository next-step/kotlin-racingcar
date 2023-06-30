package racingcar.domain

import racingcar.util.NumberGenerator

data class Cars(
    private val cars: List<Car>,
) : Iterable<Car> by cars {

    fun moveAll() {
        cars.forEach { it.move() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun createCars(carNameList: List<String>, numberGenerator: NumberGenerator): Cars = Cars(
            carNameList.map { name ->
                Car(name, numberGenerator)
            },
        )
    }
}
