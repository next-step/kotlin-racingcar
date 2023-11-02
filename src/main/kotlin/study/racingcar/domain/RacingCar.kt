package study.racingcar.domain

import study.racingcar.application.CarName

/**
 * 기능
 *    - 식별할 수 있는 id 와 위치값 상태를 갖는다.
 *    - 앞뒤로 이동해서 위치값 상태를 수정하는 함수를 제공한다.
 *    - 초기 위치보다 뒤로 이동하지는 않는다.
 * */

data class RacingCar(
    val name: CarName,
    private var _position: Int = DEFAULT_POSITION
) {
    val currentPosition: Int
        get() = _position

    fun moveForward(gameRule: GameRule) {
        gameRule.setGameRule(getRandomNumber())  // 주입 받은 GameRule 의 상태를 모든 racingCar 마다 변경합니다.

        if (gameRule.getResult()) {
            _position += 1
        }
    }

    // TODO-review : 테스트 하기 어려운 random 을 객체 그래프에서 최대한 높은 곳으로 끌어올려 봤습니다.
    // 하지만, 여전히 RacingGame, MainUI 는 테스트 하기 어려운데요.
    // 이럴 경우, 설계를 다시 해야할지 / 테스트를 포기해야할지 고민이 됩니다.
    private fun getRandomNumber(): Int {
        return (0..9).random()
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}
