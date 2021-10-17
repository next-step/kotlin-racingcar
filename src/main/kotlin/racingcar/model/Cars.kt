package racingcar.model

data class Cars(private var cars: List<Car>) {

    init {
        checkCarsMinimumSize(cars.size)
    }

    private fun checkCarsMinimumSize(size: Int) {
        require(size > 0) {
            "at least 1 size required"
        }
    }

    fun move() {
        this.cars = cars.map { car -> car.tryMove() }
    }

    fun filterWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun snapshot(round: Int): RacingCarSnapshot = RacingCarSnapshot(round, cars.toList())
}
