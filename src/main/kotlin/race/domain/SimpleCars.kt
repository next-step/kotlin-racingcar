package race.domain

class SimpleCars(carNames: List<String>) {
    val carList: List<SimpleCar>

    init {
        this.carList = carNames.map { SimpleCar(it) }
    }

    fun findWinners(): List<SimpleCar> {
        val max = carList.maxBy { it.location }
        return carList.filter { it.location == max.location }
    }

    fun moveAll() {
        carList.forEach { it.move((0..9).random()) }
    }

    fun forEach(block: (SimpleCar) -> Unit) = carList.forEach(block)
}
