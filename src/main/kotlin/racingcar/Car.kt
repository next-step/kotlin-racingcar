package racingcar

import kotlin.random.Random

class Car(position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    fun move(number: Int, movable: (Int) -> Boolean) {
        if (movable(number)) {
            position++
        }
    }

    fun toMessage(): String = if (position > 0) "-".repeat(position) else ""

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        const val FORWARD_CONDITION_NUMBER: Int = 4
    }
}

class Cars(private val cars: List<Car>) {
    fun move() {
        cars.forEach { car ->
            car.move(Random.nextInt(MAX_RANGE_NUMBER)) { it >= Car.FORWARD_CONDITION_NUMBER }
        }
    }

    fun toMessages(): String {
        val stringBuilder = StringBuilder()
        cars.forEach { car ->
            stringBuilder.appendLine(car.toMessage())
        }
        return stringBuilder.toString()
    }

    companion object {
        private const val MAX_RANGE_NUMBER = 9
        fun of(count: Int): Cars {
            val cars = List(count) { Car() }
            return Cars(cars)
        }
    }
}
