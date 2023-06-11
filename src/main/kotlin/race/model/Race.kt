package race.model

import javax.imageio.event.IIOReadUpdateListener

class Race(
    private val numberOfCar: Int,
    private val numberOfRace: Int
) {

    private val _cars = mutableListOf<Car>().apply {
        repeat(numberOfCar) {
            add(Car())
        }
    }

    val cars: List<Car> get() = _cars.toList()

    private fun carsMove() {
        _cars.forEach {
            it.go()
        }
    }

    fun startRacing(update: ((List<Int>) -> Unit)? = null){
        repeat(numberOfRace) {
            carsMove()
            val carPositionList = _cars.map { it.position }
            update?.invoke(carPositionList)
        }
    }
}

