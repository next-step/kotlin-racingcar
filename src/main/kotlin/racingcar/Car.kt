package racingcar

import kotlin.random.Random

class Car(val name: String, position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    init {
        require(name.length <= MAX_RANGE_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(number: Int, movable: (Int) -> Boolean) {
        if (movable(number)) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val MAX_RANGE_NAME_LENGTH: Int = 5
        const val FORWARD_CONDITION_NUMBER: Int = 4
    }
}

class Cars(cars: List<Car>) {
    private val _cars: List<Car> = cars.toList()
    val cars: List<Car> get() = _cars

    fun move() {
        cars.forEach { car ->
            car.move(Random.nextInt(MAX_RANGE_NUMBER)) { it >= Car.FORWARD_CONDITION_NUMBER }
        }
    }

    fun maxPosition(): Int {
        return cars.maxOfOrNull { car -> car.position } ?: 0
    }

    companion object {
        private const val MAX_RANGE_NUMBER = 9

        fun of(names: List<String>): Cars {
            val cars = names.map {
                Car(it)
            }
            return Cars(cars)
        }
    }
}
