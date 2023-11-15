package racingcar.domain

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

    fun maxOfPositions(): Int {
        return cars.maxOf { car -> car.position }
    }

    companion object {
        fun of(names: List<String>): Cars {
            val cars = names.map {
                Car.from(it)
            }
            return Cars(cars)
        }
    }
}
