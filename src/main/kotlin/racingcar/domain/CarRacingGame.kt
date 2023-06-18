package racingcar.domain

class CarRacingGame(
    carNames: List<String>,
    private val round: Int,
    private val moveStrategy: MoveStrategy
) {
    private var currentRound: Int = 0
    val cars: List<Car> = carNames.map { Car(it, moveStrategy = moveStrategy) }

    constructor(carCount: Int, round: Int, moveStrategy: MoveStrategy) :
        this((1..carCount).map { it.toString() }, round, moveStrategy)

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
