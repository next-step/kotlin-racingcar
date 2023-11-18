package racingcar.domain

import racingcar.dto.CarDto

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    init {
        require(name.length <= MAX_RANGE_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(moveStrategy: MoveStrategy) {
        if (moveStrategy.isMovable()) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val MAX_RANGE_NAME_LENGTH: Int = 5
        fun from(name: String): Car {
            return Car(name)
        }
    }
}

class Cars(cars: List<Car>) {
    private val _cars: List<Car> = cars.toList()
    val cars: List<Car> get() = _cars

    fun move() {
        cars.forEach { car ->
            car.move(RandomMoveStrategy)
        }
    }

    companion object {
        private const val RACING_CAR_DELIMITER = ","

        fun of(inputName: String): Cars {
            val names = inputName.split(RACING_CAR_DELIMITER)
            val cars = names.map {
                Car.from(it)
            }
            return Cars(cars)
        }
    }

    fun toCarDtoList(): List<CarDto> = cars.map { CarDto.from(it) }
}
