package racingcar.domain

class CarRacingGame(
    carNames: List<String>,
    private val round: Int,
    private val moveStrategy: MoveStrategy
) {
    private var currentRound: Int = 0
    val cars: List<Car> = carNames.map { Car(it, moveStrategy = moveStrategy) }

    fun race(raceResultHandler: (List<Car>) -> Unit): RacingResult {
        while (hasNextRound()) {
            runRound()
            raceResultHandler.invoke(cars)
        }

        return RacingResult(cars)
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

    companion object {

        fun of(carCount: Int, round: Int, moveStrategy: MoveStrategy): CarRacingGame {
            return CarRacingGame((1..carCount).map { it.toString() }, round, moveStrategy)
        }
    }
}
