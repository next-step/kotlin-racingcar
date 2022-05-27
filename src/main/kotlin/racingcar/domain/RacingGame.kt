package racingcar.domain

class RacingGame(carNames: String, val tryCnt: Int) {
    private val nameList = carNames.split(SPLIT_TEXT)
    var cars: List<Car> = nameList.map { Car(name = it) }

    private fun init(): List<CarHistory> {
        return cars.map { it.prepare() }
    }
    fun execute(method: () -> Int): List<CarHistory> {
        return cars.map { it.move(method()) }
    }

    fun play(method: () -> Int): List<List<CarHistory>> {
        return List(tryCnt) { index ->
            if (index == 0) {
                init()
            } else {
                execute(method)
            }
        }
    }

    companion object {
        private const val SPLIT_TEXT = ","
    }
}
