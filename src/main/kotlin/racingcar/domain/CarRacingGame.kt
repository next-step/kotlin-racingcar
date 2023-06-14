package racingcar.domain

class CarRacingGame(
    carCount: Int,
    private val round: Int,
    private val moveStrategy: MoveStrategy
) {
    private var currentRound: Int = 0
    val cars: List<Car> = (1..carCount).map { Car() }

    fun runRound() {
        check(hasNextRound()) { "경주가 종료되었습니다." }
        moveCars()
        currentRound++
    }

    fun hasNextRound(): Boolean = currentRound < round

    private fun moveCars() {
        cars.forEach {
            if (moveStrategy.isMovable()) it.move()
        }
    }
}
