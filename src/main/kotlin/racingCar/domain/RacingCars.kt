package racingCar.domain

import racingCar.strategy.MoveStrategy.Companion.getMoveStrategy
import racingCar.view.OutputView

class RacingCars(carNames: List<String>) {
    private var participants = carNames.map { Car(it) }

    fun startRacing(trialCount: Int): List<Car> {
        repeat(trialCount) { index ->
            println("${index + 1} 번째 경주")
            tryMove()
        }
        return participants
    }

    private fun getMoveValue(): Boolean {
        val resultStrategy = getMoveStrategy()
        return resultStrategy.isMove()
    }

    private fun tryMove() {
        participants.forEach {
            it.changeStateRacingCar(getMoveValue())
        }
        OutputView.getCarRacingResult(participants)
    }
}
