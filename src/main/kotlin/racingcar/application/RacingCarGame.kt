package racingcar.application

import racingcar.domain.Car
import racingcar.domain.CarFactory
import racingcar.domain.CarMovementRule
import racingcar.domain.RaceWinnerDecider

class RacingCarGame(
    private val messagePrinter: MessagePrinter,
    private val carNameReader: CarNameReader,
    private val moveAttemptCountReader: MoveAttemptCountReader,
) {
    fun start() {
        val carNames = carNameReader.read()
        val cars = CarFactory.create(carNames)

        val moveAttemptCount = moveAttemptCountReader.read()

        runRace(moveAttemptCount, cars)
        decideWinners(cars)
    }

    private fun runRace(
        moveAttemptCount: Int,
        cars: List<Car>,
    ) {
        messagePrinter.printResultMessage()

        repeat(moveAttemptCount) {
            CarMovementRule.apply(cars)
            messagePrinter.printRaceResultMessage(RaceResults.from(cars))
        }
    }

    private fun decideWinners(cars: List<Car>) {
        val winners = RaceWinnerDecider.decide(cars)
        messagePrinter.printWinners(Winners.from(winners))
    }
}
