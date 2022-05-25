package racingcar.domain

class RacingGame(carNames: String, val tryCnt: Int) {
    private val nameList = carNames.split(SPLIT_TEXT)
    var cars: List<Car> = nameList.map { Car(name = it) }

    fun execute(method: () -> Int): List<CarHistory> {
        return cars.map { it.move(method()) }
    }

    fun play(method: () -> Int): List<List<CarHistory>> {
        return List(tryCnt) { execute(method) }
    }

    companion object {
        const val SPLIT_TEXT = ","
    }
}
