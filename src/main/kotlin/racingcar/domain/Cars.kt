package racingcar.domain

import racingcar.util.NumberGenerator

data class Cars(
    private val cars: List<Car>,
) : Iterable<Car> {

    fun moveAll() {
        cars.forEach { it.move() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
    }

    override fun iterator(): Iterator<Car> =
        cars.iterator()

    companion object {
        fun createCars(carNameList: List<String>, numberGenerator: NumberGenerator): Cars = Cars(
            carNameList.map { name ->
                Car(name, numberGenerator)
            },
        )
    }
}
