package race.model

class Race(
    private var cars: List<Car>,
    private val numberOfRace: Int,
) {

    fun start(update: ((List<Car>) -> Unit)? = null): Winner {
        repeat(numberOfRace) {
            racing()
            update?.invoke(cars)
        }

        return Winner(cars)
    }

    private fun racing() {
        cars = cars.map {
            it.move(RandomEngine().cycle())
        }
    }

    companion object {

        const val MOVE_RANGE = 10
        fun createCars(carRacers: List<String>) = carRacers.map {
            Car(_name = it)
        }
    }
}
