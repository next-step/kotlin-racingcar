package study.racingcar.domain

/**
 * 입력 받은 게임 룰에 대해 승패를 결정한다.
 * */
class Game(private var gameRule: GameRule) {
    fun setGameRule(newGameRule: GameRule) {
        gameRule = newGameRule
    }

    fun play(): Boolean {
        return gameRule.getResult()
    }
}
