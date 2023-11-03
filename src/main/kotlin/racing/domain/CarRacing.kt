package racing.domain

class CarRacing(
    private val numberStrategy: NumberStrategy,
    private val recorder: CarRacingRecordStrategy,
    private val cars: List<Car>,
) {

    fun race(tryCount: Int): CarRacingResult {
        val results = raceWithRecordResult(cars, tryCount)
        val winners = recorder.findWinners(cars)
        return CarRacingResult(results, winners)
    }

    private fun raceWithRecordResult(cars: List<Car>, tryCount: Int): List<List<Car>> {
        return List(tryCount) {
            cars.racePerRound()
            recorder.recordRacingResultPerRound(cars)
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop(numberStrategy.getNumber())
        }
    }
}
