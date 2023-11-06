package racingcar

import kotlin.random.Random

class Car(position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    fun move(condition: Int) {
        if (condition >= FORWARD_CONDITION_NUMBER) {
            position++
        }
    }

    fun toMessage(): String = if (position > 0) "-".repeat(position) else ""

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val FORWARD_CONDITION_NUMBER: Int = 4
    }
}

class Cars(private val cars: List<Car>) {
    fun move() {
        cars.forEach {
            it.move(Random.nextInt(9))
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
        fun of(count: Int): Cars {
            val cars = List(count) { Car() }
            return Cars(cars)
        }
    }
}
