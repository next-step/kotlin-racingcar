package racingcar.domain

import racingcar.vo.Name
import racingcar.vo.Position
import racingcar.vo.Round

class RacingGame(private val cars: List<Car>, private var round: Round) {

    constructor(names: List<String>, round: Int) : this(names.map { Car(it) }, Round(round))

    init {
        validateEmptyCars()
        validateNoRound()
    }

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

    companion object {
        private const val MIN_CAR_COUNT = 2
    }
}
