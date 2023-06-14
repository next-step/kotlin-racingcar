package racingCar2

class RacingField(
    private val cars: List<Car>,
    private val _gameCount: Int,
) {
    private val resultView = ResultView()
    val carNames: List<String> get() = cars.map { it.name }
    val gameCount: Int get() = _gameCount
    val winners: List<String>
        get(): List<String> {
            val maxPosition = cars.maxOf { it.position }
            return cars.filter { it.position == maxPosition }.map { it.name }
        }

    constructor(carNames: Array<String>, gameCount: Int) : this(List(carNames.size) { Car(carNames[it]) }, gameCount)

    fun racingStart(numberGenerator: NumberGenerator) {
        resultView.showResultMessage()
        repeat(_gameCount) {
            this.gameStart(numberGenerator)
            resultView.showGameResult(cars)
        }

        resultView.showWinners(winners)
    }

    private fun gameStart(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.getRandomNumber()) }
    }
}
