package race.model

class Race(
    private val cars: List<Car>,
    private val numberOfRace: Int
) {

    fun startRacing(update: ((List<Car>) -> Unit)? = null): String {
        repeat(numberOfRace) {
            carsMove()
            update?.invoke(cars)
        }

        return getWinner()
    }

    private fun carsMove() {
        cars.forEach {
            it.go()
        }
    }

    private fun getWinner(): String = cars.maxOf { it.position }.let {
            cars.filter { car -> car.position == it }.joinToString { it.name }
        }

    companion object {
        fun createCars(carRacers: List<String>, engine: Engine = RandomEngine()) = carRacers.map {
            Car(_name = it, engine = engine)
        }
    }
}
