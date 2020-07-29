package racingcar.domain

import racingcar.strategy.Strategy

class RacingCars(
    private val carNames: List<String>,
    private val strategy: Strategy
) {
    private val cars = carNames.let {
        val list = mutableListOf<Car>()
        it.forEach { name ->
            list.add(Car(name, strategy))
        }
        list.toList()
    }

    internal fun moveForwardAll() {
        cars.forEach {
            it.moveForward()
        }
    }

    internal fun getWinner(): List<Car> {
        return cars.filter {
            it.isWinner(findMax(cars))
        }
    }

    private fun findMax(cars: List<Car>): Int {
        return cars.maxBy { it.currentPosition }?.currentPosition ?: 0
    }

    override fun toString(): String {
        return cars.joinToString("") { "${it.getName()} : ${it.getDistance()}\n" }
    }
}
