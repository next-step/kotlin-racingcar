package racingcar.domain

class RacingCar(
    var nickname: Nickname,
    private var gameRule: GameRule = RandomGameRule
) {

    var position: Position = Position()
        private set

    fun applyGameRule(gameRule: GameRule) {
        this.gameRule = gameRule
    }

    fun move() {
        val direction = gameRule.getMovingDirection()
        this.position.plus(direction.position)
    }

    fun copy(): RacingCar = RacingCar(this.nickname, this.gameRule).apply {
        this.position = Position(this@RacingCar.position.value)
    }
}
