package racingcar.domain

class RacingGame(carCnt: Int, val tryCnt: Int) {
    var cars = mutableListOf<Car>()

    init {
        repeat(carCnt) { cars.add(Car()) }
    }

    fun execute(method: () -> Int): List<Car> {
        repeat(tryCnt) {
            cars.forEach {
                it.move(method())
            }
        }
        return cars.toList()
    }
}
