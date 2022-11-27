package racing.domain

private const val MINIMUM_COUNT_OF_CARS = 2

class Cars(private val cars: List<Car>) {

    init {
        require(cars.size >= MINIMUM_COUNT_OF_CARS) {
            "자동차는 최소 ${MINIMUM_COUNT_OF_CARS}대 이상이어야 합니다."
        }
    }

    private constructor(numberOfCars: Int) : this(
        List(numberOfCars) { Car() }
    )

    companion object {
        fun create(numberOfCars: Int): Cars {
            return Cars(numberOfCars)
        }
    }

    fun move(movable: Movable) {
        cars.forEach {
            it.move(movable.move())
        }
    }

    fun positions(): List<Int> {
        return cars.map { it.position }
    }
}
