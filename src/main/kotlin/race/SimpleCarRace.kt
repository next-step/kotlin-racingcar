package race

class SimpleCarRace(cars: Int, val moves: Int) {
    val carList = mutableListOf<SimpleCar>()

    init {
        repeat(cars) { carList.add(SimpleCar()) }
    }

    fun start() {
        repeat(moves) {
            carList.forEach { it.dice() }
            ResultView().printResult(carList)
        }
    }
}
