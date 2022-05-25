package racingcar.domain

class RacingGame(carNames: String, val tryCnt: Int) {
    private val nameList = carNames.split(",")
    var cars: List<Car> = nameList.map { Car(name = it) }

    fun execute(method: () -> Int): List<CarHistory> {
        return cars.map { it.move(method()) }
    }

    fun play(method: () -> Int): List<List<CarHistory>> {
        return List(tryCnt) { execute(method) }
    }
}
