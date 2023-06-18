package race.model

class Race(
    private var cars: List<Car>,
    private val numberOfRace: Int,
    private val engine: Engine = RandomEngine()
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
            it.move(engine.cycle())
        }
    }

    companion object {

        fun createCars(carRacers: List<String>) = carRacers.map {
            Car(name = it)
        }
    }
}
