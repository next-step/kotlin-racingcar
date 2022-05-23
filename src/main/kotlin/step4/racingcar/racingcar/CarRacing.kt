package step4.racingcar.racingcar

class CarRacing(racers: List<String>, private val moveCount: Int) {

    private val car = racers.map { Car(it) }

    val gameResult: GameResult
        get() = GameResult(car, moveCount)

    fun execute(carEngine: NumberGenerator) {
        repeat(moveCount) {
            executeCarRacing(car, carEngine)
        }
    }

    private fun executeCarRacing(carList: List<Car>, carEngine: NumberGenerator) {
        carList.forEach {
            val engine = carEngine.generate()
            it.move(engine)
        }
    }
}
