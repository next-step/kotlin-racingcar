package racingcar

class RacingGame(
    nameInput: String,
    inputRoundCount: Int,
    private val numberGenerator: NumberGenerator,
) {
    private val cars: Cars = Cars.makeNewCars(nameInput)
    private var round = Round(inputRoundCount)

    fun play() {
        round = round.decrease()
        cars.move(numberGenerator)
    }

    fun isEnd(): Boolean {
        return round.isZero()
    }

    fun extractCarNames(): List<String> {
        return cars.getCarNames()
    }

    fun extractNowCarPositions(): List<Int> {
        return cars.getPositionValues()
    }

    fun extractWinner(): List<String> {
        val maxPosition = cars.getPositionValues().max()
        return cars.getCarNames()
            .filter { cars.getPositionValues()[cars.getCarNames().indexOf(it)] == maxPosition }
    }
}
