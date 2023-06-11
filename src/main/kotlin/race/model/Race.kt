package race.model

class Race(
    private val raceCars: List<String>,
    private val numberOfRace: Int
) {

    private val cars = mutableListOf<Car>().apply {
        raceCars.forEach {
            add(Car(it))
        }
    }

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
}
