package study.racingcar.domain

import study.racingcar.view.OutputView

/**
 * RacingCar 을 Wrapping 하는 일급 컬렉션
 * */
data class RacingCars(private val _racingCars: List<RacingCar>) {
    val racingCars: List<RacingCar>
        get() = _racingCars

    val currentWinners: String
        get() {
            val winner = _racingCars.maxByOrNull { it.currentPosition }
            require(winner != null) { "RacingCar 리스트가 비었습니다. " }
            return _racingCars
                .filter { it.currentPosition == winner.currentPosition }
                .joinToString(",") { it.name.toString() }
        }

    fun playGame(tryCount: Int, gameRule: GameRule) {
        (1..tryCount).map { _ ->
            _racingCars.forEach { rc ->
                rc.moveForward(gameRule, gameRule.getRandomNumber())
            }
            OutputView.showResult(_racingCars)
        }
    }
}
