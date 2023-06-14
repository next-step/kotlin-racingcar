package racing_car.domain.race

import racing_car.domain.car.Car

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
