package racingcar.domain

class RacingGame(val cars: List<Car>, private var round: Round) {

    constructor(countOfCars: Int, round: Int) : this(List(countOfCars) { Car() }, Round(round))

    init {
        validateEmptyCars()
        validateNoRound()
    }

    private fun validateEmptyCars() {
        if (cars.size < MIN_CAR_COUNT) throw IllegalArgumentException("at least 2 cars are needed to play")
    }

    private fun validateNoRound() {
        if (!round.hasNext()) throw IllegalArgumentException("at least 1 round is needed to play")
    }

    fun playNextRound(moveStrategy: MoveStrategy) {
        round = round.next()
        cars.forEach { it.moveForward(moveStrategy) }
    }

    fun hasNextRound() = round.hasNext()

    companion object {
        private const val MIN_CAR_COUNT = 2
    }
}
