package race

class RaceManager(cars: String, private val moves: Int) {
    val carList: List<SimpleCar>

    init {
        carList = parseCarList(cars).map { SimpleCar(it) }
    }

    private fun parseCarList(cars: String): List<String> {
        return cars
            .split(',')
            .map { it.trim() }
            .filter { it.isNotBlank() }
    }

    fun start() {
        repeat(moves) {
            carList.forEach { it.move() }
            ResultView().printResult(carList)
        }
    }
}
