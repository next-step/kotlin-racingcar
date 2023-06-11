class RacingField(
    private val cars: MutableList<Car>,
    private var gameCount: Int
) {
    constructor(carCount: Int, gameCount: Int) : this(mutableListOf(), 0) {
        createCars(carCount)
        this.gameCount = gameCount
    }

    private fun createCars(count: Int) {
        for (i in 1..count) {
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
