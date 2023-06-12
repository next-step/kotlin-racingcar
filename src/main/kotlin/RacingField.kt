class RacingField(
    private val cars: MutableList<Car>,
    private val gameCount: Int
) {
    constructor(carCount: Int, gameCount: Int) : this(mutableListOf(), gameCount) {
        createCars(carCount)
    }

    private fun createCars(count: Int) {
        repeat(count) {
            cars.add(Car())
        }
    }

    fun getGameCount(): Int {
        return gameCount
    }

    fun gameStart(): MutableList<Car> {
        moveCars()
        return cars
    }

    private fun moveCars() {
        cars.forEach { it.move() }
    }

    fun getCarCount(): Int {
        return cars.size
    }
}
