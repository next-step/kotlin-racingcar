package racingcar.domain

import racingcar.domain.strategy.MovableStrategy

class Race(private val cars: Cars, private val totalRound: Int) {
    init {
        require(cars.getSize() >= MINIMUM_CARS_SIZE) { "경주는 최소 하나 이상의 자동차가 있어야 진행될 수 있습니다." }
        require(totalRound >= MINIMUM_RACE_ROUND) { "경주는 최소 한번 이상의 라운드가 진행되어야 합니다." }
    }

    fun run(movableStrategy: MovableStrategy): RaceResult {
        return RaceResult(
            List(totalRound) {
                cars.move(movableStrategy)
                RoundHistory(it, cars.record())
            }
        )
    }

    companion object {
        private const val MINIMUM_RACE_ROUND = 1
        private const val MINIMUM_CARS_SIZE = 1
    }
}
