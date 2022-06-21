package racingcar.domain

object CarRace {
    fun start(carCount: CarCount, trialCount: TrialCount): RaceResult =
        race(
            initCars(carCount), trialCount
        )

    private fun initCars(carCount: CarCount): Cars =
        Cars(
            (0 until carCount.value).map {
                Car()
            }
        )

    private fun race(cars: Cars, trialCount: TrialCount): RaceResult =
        RaceResult(
            (0 until trialCount.value).associate {
                Trial(it) to cars.move()
            }
        )
}

@JvmInline value class CarCount(val value: Int) {
    init {
        require(value > 0) { "자동차 수는 1대 이상이어야 해요. given: $value" }
    }
}
@JvmInline value class TrialCount(val value: Int) {
    init {
        require(value > 0) { "경기 횟수는 1회 이상이어야 해요. given: $value" }
    }
}
