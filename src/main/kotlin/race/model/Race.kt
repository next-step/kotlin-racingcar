package race.model

class Race(
    private val cars: List<Car>,
    private val numberOfRace: Int
) {

    fun getCarSize() = cars.size

    private fun carsMove() {
        cars.forEach {
            it.go()
        }
    }

    fun startRacing(update: ((List<Pair<String, Int>>) -> Unit)? = null) {
        repeat(numberOfRace) {
            carsMove()
            val result = cars.map { it.name to it.position }
            update?.invoke(result)
        }
    }

    fun getWinner(): String {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.joinToString { it.name }
    }

    companion object {
        fun createCars(carRacers: List<String>, engine: Engine = RandomEngine()) = mutableListOf<Car>().apply {
            carRacers.forEach {
                add(Car(_name = it, engine = engine))
            }
        }
    }
}
