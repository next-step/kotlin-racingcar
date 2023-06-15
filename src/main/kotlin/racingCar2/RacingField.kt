package racingCar2

class RacingField(
    private val cars: List<Car>,
    private val _gameCount: Int,
) {
    private val resultView = ResultView()
    val carNames: List<String>
        get() = cars.map { it.name }
    val gameCount: Int
        get() = _gameCount

    constructor(carNames: Array<String>, gameCount: Int) : this(List(carNames.size) { Car(carNames[it]) }, gameCount)

    fun racingStart(numberGenerator: NumberGenerator): List<String> {
        val gameRecords = mutableListOf<GameResult>()

        repeat(_gameCount) {
            gameRecords.add(this.playGame(numberGenerator))
        }

        val winners = this.findWinners()
        resultView.showRacingResult(gameRecords, winners)

        return winners
    }

    private fun playGame(numberGenerator: NumberGenerator): GameResult {
        val gameResult = mutableListOf<Player>()

        cars.forEach {
            it.move(numberGenerator.getRandomNumber())
            gameResult.add(Player(it.name, it.position))
        }

        return GameResult(gameResult)
    }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
