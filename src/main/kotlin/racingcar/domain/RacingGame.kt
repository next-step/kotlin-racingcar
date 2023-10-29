package racingcar.domain

class RacingGame(
    private val gameRule: GameRule,
    private val gameRound: Round,
    val cars: List<RacingCar>
) {

    private var progressRound: Round = Round(1)

    fun nextRound() {
        require(hasNextRound()) { "게임이 종료되었습니다." }

        this.cars.forEach { it.move(gameRule.getMovingDirection()) }
        this.progressRound = this.progressRound.next()
    }

    fun hasNextRound() = this.gameRound.isOver(this.progressRound)
}
