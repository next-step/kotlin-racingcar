class RacingField(
    val cars: MutableList<Car> = mutableListOf(),
    private var gameCount: Int = 0
) {
    fun createCars(count: Int) {
        for (i in 1..count) {
            cars.add(Car())
        }
    }

    fun setGameCount(count: Int) {
        gameCount = count
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
}
