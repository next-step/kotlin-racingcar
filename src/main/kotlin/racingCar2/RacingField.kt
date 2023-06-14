package racingCar2

class RacingField(
    private val cars: List<Car>,
    private val _gameCount: Int,
) {
    private val resultView = ResultView()
    val carNames: List<String> get() = cars.map { it.name }
    val gameCount: Int get() = _gameCount

    constructor(carNames: Array<String>, gameCount: Int) : this(List(carNames.size) { Car(carNames[it]) }, gameCount)

    fun racingStart(numberGenerator: NumberGenerator): List<String> {
        resultView.showResultMessage()
        repeat(_gameCount) {
            this.gameStart(numberGenerator)
            resultView.showGameResult(cars)
        }

        val winners = this.getWinners()
        resultView.showWinners(winners)

        return winners
    }

    private fun gameStart(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.getRandomNumber()) }
    }

    private fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
