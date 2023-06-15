package racingcar.domain

class CarRacingGame(
    carCount: Int,
    private val round: Int,
    private val moveStrategy: MoveStrategy
) {
    private var currentRound: Int = 0
    val cars: List<Car> = (1..carCount).map { Car("$it", moveStrategy = moveStrategy) }

    fun race(raceResultHandler: (RacingResult) -> Unit) {
        while (hasNextRound()) {
            runRound()
            raceResultHandler.invoke(RacingResult(cars, hasNextRound()))
        }
    }

    private fun runRound() {
        check(hasNextRound()) { "경주가 종료되었습니다." }
        moveCars()
        currentRound++
    }

    private fun hasNextRound(): Boolean = currentRound < round

    private fun moveCars() {
        cars.forEach { it.move() }
    }
}
