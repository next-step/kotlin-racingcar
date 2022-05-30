package step4.racingcar.domain

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

    private fun executeCarRacing(carList: List<Car>, movingSignal: NumberGenerator) {
        carList.forEach {
            val signal = movingSignal.generate()
            it.move(signal)
        }
    }
}
