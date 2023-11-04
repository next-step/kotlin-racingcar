package race.domain

class RaceManager(cars: List<String>, val moves: Int) {
    val carList: List<SimpleCar>

    init {
        carList = cars.map { SimpleCar(it) }
    }

    fun findWinners(): List<SimpleCar> {
        val max = carList.maxBy { it.location }

        return carList.filter { it.location == max.location }
    }
}
