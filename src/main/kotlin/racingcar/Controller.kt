package racingcar

import racingcar.domain.ForwardStrategy
import racingcar.domain.MoveHistory
import racingcar.domain.RacingCar

class Controller(carNames: String, tryCount: Int) {
    private val racingCar = RacingCar(carNames, tryCount)
    private lateinit var racingHistory: MoveHistory

    fun startRacing() {
        racingHistory = racingCar.start(ForwardStrategy.DefaultForward)
    }

    fun getWinningCarNames(): List<String> = racingHistory.getWinningCarNames()

    fun getCarNames(): List<String> = racingHistory.moveHistory.keys.toList()

    fun getMoveInfos(name: String): List<Int> = racingHistory.moveHistory[name] ?: mutableListOf()
}
