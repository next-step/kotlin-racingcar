class RacingField(
    private val cars: List<Car>,
    private val gameCount: Int
) {
    constructor(carCount: Int, gameCount: Int) : this(List(carCount) { Car() }, gameCount)

    fun getGameCount(): Int {
        return gameCount
    }

    fun gameStart(): List<Car> {
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
