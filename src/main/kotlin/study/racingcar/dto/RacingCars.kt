package study.racingcar.dto

import study.racingcar.domain.GameRule
import study.racingcar.view.OutputView

/**
 * RacingCar 을 Wrapping 하는 일급 컬렉션
 * */
data class RacingCars(private val _racingCars: List<RacingCar>) {

    val currentWinners: List<RacingCar>
        get() {
            val winner = _racingCars.maxByOrNull { it.position }
            require(winner != null) { "RacingCar 리스트가 비었습니다. " }
            return _racingCars.filter { it.position == winner.position }
        }

    fun playGame(tryCount: Int, gameRule: GameRule) {
        repeat(tryCount) {
            _racingCars.forEach { it.moveForward(gameRule) }
            OutputView.showResult(_racingCars)
        }
    }
}
