package race.domain

class SimpleCars(private val carList: List<SimpleCar>) {
    fun findWinners(): List<SimpleCar> {
        val max = carList.maxBy { it.location }
        return carList.filter { it.location == max.location }
    }

    fun moveAll() {
        carList.forEach { it.move((0..9).random()) }
    }

    fun forEach(block: (SimpleCar) -> Unit) = carList.forEach(block)

    companion object {
        fun byNames(carNames: List<String>) = SimpleCars(carNames.map { SimpleCar(it) })
    }
}
