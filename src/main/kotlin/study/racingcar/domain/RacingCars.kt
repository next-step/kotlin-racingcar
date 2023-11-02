package study.racingcar.domain

import study.racingcar.application.OutputView

/**
 * RacingCar 을 Wrapping 하는 일급 컬렉션
 * */
data class RacingCars(private val _racingCars: List<RacingCar>) {
    val racingCars: List<RacingCar>
        get() = _racingCars

    val curWinners: String
        get() {
            val winner = _racingCars.maxBy { it.currentPosition }!!
            return _racingCars
                .filter { it.currentPosition == winner.currentPosition }
                .joinToString(",") { it.name.toString() }
        }

    fun playGame(tryCount: Int, gameRule: GameRule) {
        (1..tryCount).map { _ ->
            _racingCars.forEach { rc ->
                rc.moveForward(gameRule, getRandomNumber())
            }
            OutputView.showResult(_racingCars)
        }
    }

    // TODO-review : 테스트 하기 어려운 random 을 객체 그래프에서 최대한 높은 곳으로 끌어올려 봤습니다.
    //  하지만, 컨트롤러(오케스트레이션) 역할인 RacingGame 는 테스트 하기 어려운데요.
    //  당연한것인지 아니면 설계를 다시 해서 컨트롤러도 테스트 가능하게 만들어야 하는지 궁금합니다.
    private fun getRandomNumber(): Int {
        return (0..9).random()
    }
}
