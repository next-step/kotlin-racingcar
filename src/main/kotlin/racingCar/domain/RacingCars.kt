package racingCar.domain

import racingCar.strategy.MoveStrategy.Companion.getMoveStrategy
import racingCar.view.OutputView

class RacingCars() {
    private var participant = listOf<Car>()

    fun generateCar(carNames: List<String>) {
        participant = carNames.map { Car(it) }
    }

    fun startRacing(trialCount: Int): List<Car> {
        repeat(trialCount) { index ->
            println("${index + 1} 번째 경주")
            tryMove(getMoveValue())
        }
        return participant
    }

    private fun getMoveValue(): Int {
        val resultStrategy = getMoveStrategy()
        return resultStrategy.moveCar()
    }

    private fun tryMove(randomMoveValue: Int) {
        participant.forEach {
            it.changeStateRacingCar(randomMoveValue)
        }
        OutputView.getCarRacingResult(participant)
    }

    fun getRacingWinner(racingCars: List<Car>): String {
        val maxDistance = racingCars.map { it.distance }.max()
        return racingCars.filter { it.distance == maxDistance && it.distance > 0 }.joinToString { it.name }
    }
}
