package racingcar

class RacingGame(carCnt: Int, val tryCnt: Int) {
    var cars = mutableListOf<Car>()

    init {
        repeat(carCnt) { cars.add(Car()) }
    }

    fun execute() {
        repeat(tryCnt) {
            cars.forEach {
                it.move(it.generate())
            }
        }
    }
}
