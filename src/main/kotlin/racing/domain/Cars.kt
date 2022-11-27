package racing.domain

private const val MINIMUM_COUNT_OF_CARS = 2

class Cars(private val cars: List<Car>) {

    init {
        require(cars.size >= MINIMUM_COUNT_OF_CARS) {
            "자동차는 최소 ${MINIMUM_COUNT_OF_CARS}대 이상이어야 합니다."
        }
    }

    constructor(numberOfCars: Int) : this(
        (1..numberOfCars).map { Car() }
    )

    fun move(movable: Movable) {
        cars.forEach { car ->
            car.move(movable.move())
        }
    }

    fun positions(): List<Int> {
        return cars.map { it.position }
    }
}
