package race.model

class Race(
    private val raceCars: List<String>,
    private val numberOfRace: Int
) {

    private val _cars = mutableListOf<Car>().apply {
        raceCars.forEach {
            Car(it)
        }

    }

    val cars: List<Car> get() = _cars.toList()

    private fun carsMove() {
        _cars.forEach {
            it.go()
        }
    }

    fun startRacing(update: ((List<Int>) -> Unit)? = null) {
        repeat(numberOfRace) {
            carsMove()
            val carPositionList = _cars.map { it.position }
            update?.invoke(carPositionList)
        }
    }
}

