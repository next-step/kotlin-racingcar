package race

class RaceManager(cars: Int, private val moves: Int) {
    private val carList = mutableListOf<SimpleCar>()

    init {
        repeat(cars) { carList.add(SimpleCar()) }
    }

    fun start() {
        repeat(moves) {
            carList.forEach { it.move() }
            ResultView().printResult(carList)
        }
    }
}
