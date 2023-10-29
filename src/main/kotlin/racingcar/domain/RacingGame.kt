package racingcar.domain

class RacingGame(
    private val gameRule: GameRule,
    private val gameRound: Int,
    val cars: List<RacingCar>
) {

    private var progressRound: Int = 0

    fun nextRound() {
        require(hasNextRound()) { "게임이 종료되었습니다." }

        this.cars.forEach { it.move(gameRule.getMovingDirection()) }
        this.progressRound++
    }

    fun hasNextRound() = this.progressRound < this.gameRound
}
