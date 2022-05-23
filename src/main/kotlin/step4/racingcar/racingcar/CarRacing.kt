package step4.racingcar.racingcar

class CarRacing(
    private val cars: List<Car>,
    private val moveCount: Int
) {
    val gameResult: GameResult
        get() = GameResult(cars, moveCount)

    fun execute(carEngine: NumberGenerator) {
        repeat(moveCount) {
            executeCarRacing(cars, carEngine)
        }
    }

    private fun executeCarRacing(carList: List<Car>, carEngine: NumberGenerator) {
        carList.forEach {
            val engine = carEngine.generate()
            it.move(engine)
        }
    }
}
