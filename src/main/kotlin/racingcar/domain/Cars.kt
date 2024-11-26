package racingcar.domain

import racingcar.util.NumberGenerator

private const val USERNAME_SPLIT_CONDITION = ","

class Cars(val cars: List<Car>) {
    fun race(generator: NumberGenerator) {
        for (car in cars) {
            val number = generator.generate()
            car.move(number)
        }
    }

    fun positions(): List<Position> {
        return cars.map { it.position }
    }

    companion object {
        fun from(usernames: String): Cars {
            return Cars(usernames.split(USERNAME_SPLIT_CONDITION).map { username -> Car.init(username) })
        }
    }
}
