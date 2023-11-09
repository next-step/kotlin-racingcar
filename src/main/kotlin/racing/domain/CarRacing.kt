package racing.domain

class CarRacing private constructor(
    private val recorder: CarRacingRecordStrategy,
    private val cars: List<Car>,
) {

    init {
        require(cars.isNotEmpty()) {
            "자동차가 0대이면 자동차 경주를 할 수 없습니다."
        }
    }

    fun race(tryCount: Int): CarRacingResult {
        val results = raceWithRecordResult(cars, tryCount)
        val winners = recorder.findWinners(cars)
        return CarRacingResult(cars, results, winners)
    }

    private fun raceWithRecordResult(cars: List<Car>, tryCount: Int): List<List<CarRacingRecord>> {
        return List(tryCount) {
            cars.racePerRound()
            recorder.recordRacingResultPerRound(cars)
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop()
        }
    }

    companion object {
        fun of(
            condition: CarRacingCondition,
            recorder: CarRacingRecordStrategy,
            carNames: List<String>,
        ): CarRacing = CarRacing(recorder, cars = carNames.map { name -> Car.of(condition, name) })

        fun of(
            recorder: CarRacingRecordStrategy,
            cars: List<Car>,
        ): CarRacing = CarRacing(recorder, cars = cars)
    }
}
