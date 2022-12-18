package racingcar

import racingcar.domain.ForwardStrategy
import racingcar.domain.MoveHistory
import racingcar.domain.RacingCar

class Controller(carNames: String, tryCount: Int) {
    private val racingCar = RacingCar(carNames, tryCount)
    private lateinit var racingHistory: MoveHistory

    fun racingStart() {
        racingHistory = racingCar.start(ForwardStrategy.DefaultForward)
    }

    fun winningCarNames() = racingHistory.getWinningCarNames()

    fun carNames() = racingHistory.moveHistory.keys.toList()

    fun moveInfo(name: String) = racingHistory.moveHistory[name] ?: mutableListOf()
}
