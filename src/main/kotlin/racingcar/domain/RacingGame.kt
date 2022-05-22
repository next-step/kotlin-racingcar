package racingcar.domain

class RacingGame(carCnt: Int, val tryCnt: Int) {
    var cars = List(carCnt) { Car() }

    fun execute(method: () -> Int): List<CarHistory> {
        return cars.map { it.move(method()) }
    }

    fun play(method: () -> Int): List<List<CarHistory>> {
        return List(tryCnt) { execute(method) }
    }
}
