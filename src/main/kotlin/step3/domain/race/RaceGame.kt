package step3.domain.race

import step3.domain.car.Car
import step3.domain.car.CarStatus

class RaceGame(private val carList: List<Car>) {

    init {
        require(carList.isNotEmpty())
    }

    fun execute(roundCount: Int): RaceResult {
        require(roundCount > 0)
        return RaceResult( List(roundCount) { _ -> startRound() })
    }

    private fun startRound(): RaceRoundResult {
        return RaceRoundResult(carList.associate {
            car -> car.move()
            car.id to car.status
        })
    }
}
