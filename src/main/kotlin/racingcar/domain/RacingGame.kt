package racingcar.domain

import racingcar.domain.vo.Position
import racingcar.domain.vo.Round

class RacingGame(private val cars: List<Car>, private var round: Round) {
    init {
        validateEmptyCars()
        validateNoRound()
    }

    constructor(names: List<String>, round: Int) : this(names.map(::Car), Round(round))

    private fun validateEmptyCars() {
        require(cars.size >= MIN_CAR_COUNT) { "at least 2 cars are needed to play" }
    }

    private fun validateNoRound() {
        require(round.hasNext()) { "at least 1 round is needed to play" }
    }

    fun playNextRound(moveStrategy: MoveStrategy): List<Position> {
        round = round.next()
        return cars.map { it.moveForward(moveStrategy) }
    }

    fun hasNextRound() = round.hasNext()

    fun findWinners(): List<Winner> {
        val winnerPosition = cars.maxOf { it.position }

        return cars.filter { it.position == winnerPosition }
            .map(::Winner)
    }

    companion object {
        private const val MIN_CAR_COUNT = 2
    }
}
