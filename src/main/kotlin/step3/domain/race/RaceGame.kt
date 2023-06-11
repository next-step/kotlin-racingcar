package step3.domain.race

import step3.domain.car.Car

class RaceGame(private val carList: List<Car>) {

    init {
        require(carList.isNotEmpty())
    }

    fun execute(roundCount: Int): RaceResult {
        require(roundCount > 0)
        return RaceResult(List(roundCount) { _ -> startRound() })
    }

    private fun startRound(): RaceRoundResult = RaceRoundResult(
        carList.map { car ->
            car.move()
            car.getCarStatus()
        }.toList()
    )
}
