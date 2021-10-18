package racingcar.model

data class Cars(private val cars: List<Car>) {

    init {
        checkCarsMinimumSize(cars.size)
    }

    private fun checkCarsMinimumSize(size: Int) {
        require(size > 0) {
            "at least 1 size required"
        }
    }

    fun move(condition: RacingCarForwardCondition): Cars = Cars(cars.map { car -> car.tryMove(condition) })

    fun filterWinners(): Cars {
        val maxPosition = getMaxPosition()
        return Cars(cars = cars.filter { it.position == maxPosition })
    }

    private fun getMaxPosition(): Int = cars.maxOf { it.position }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)

    fun getCarNames(): List<CarName> = cars.map { it.carName }
}
