package onestep.racingcar.model

class Racing(
    private val carCount: Int,
    private val tryCount: Int
) {
    lateinit var cars: List<Car>

    fun ready() {
        cars = readyCars()
    }

    fun race(show: (List<Car>) -> Unit): List<Car> {
        if (::cars.isInitialized.not()) {
            throw IllegalArgumentException("Before Race, Need Ready")
        }

        for (i in 0 until tryCount) {
            cars.map(Car::run)
            show(cars)
        }
        return cars
    }

    private fun readyCars() = mutableListOf<Car>().apply {
        for (i in 0 until carCount) {
            add(Car())
        }
    }
}
