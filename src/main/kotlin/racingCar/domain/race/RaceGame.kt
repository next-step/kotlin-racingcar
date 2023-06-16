package racingCar.domain.race

import racingCar.domain.car.Car

class RaceGame(private val cars: List<Car>) {

    init {
        require(cars.isNotEmpty()) { "게임에 참가할 자동차가 없습니다." }
    }

    fun execute(roundCount: Int): RaceResult {
        require(roundCount > 0)
        return RaceResult(List(roundCount) { _ -> startRound() })
    }

    private fun startRound(): RaceRoundResult {
        return RaceRoundResult(
            cars.associate {
                car ->
                car.move()
                car.id to car.status
            }
        )
    }
}
