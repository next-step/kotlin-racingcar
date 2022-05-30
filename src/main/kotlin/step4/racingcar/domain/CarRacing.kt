package step4.racingcar.domain

class CarRacing(
    private val cars: List<Car>,
    private val moveCount: Int
) {
    val gameResult: GameResult
        get() = GameResult(cars, moveCount)

    fun execute(movingSignal: NumberGenerator) {
        repeat(moveCount) {
            executeCarRacing(cars, movingSignal)
        }
    }

    private fun executeCarRacing(carList: List<Car>, movingSignal: NumberGenerator) {
        carList.forEach {
            val signal = movingSignal.generate()
            it.move(signal)
        }
    }

    companion object {
        fun of(racers: List<String>, movementCount: Int): CarRacing {
            return CarRacing(racers.map { Car(it) }, movementCount)
        }
    }
}
