package step4.racingcar.racingcar

class CarRacing(racers: List<String>, private val moveCount: Int) {

    private val car = racers.map { Car(it) }

    val gameResult: GameResult
        get() = GameResult(car, moveCount)

    fun execute(randomNumber: NumberGenerator) {
        repeat(moveCount) {
            executeCarRacing(car, randomNumber)
        }
    }

    private fun executeCarRacing(carList: List<Car>, randomNumber: NumberGenerator) {
        carList.forEach {
            val random = randomNumber.generate()
            it.move(random)
        }
    }
}
