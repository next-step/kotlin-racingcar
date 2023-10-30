package racing

class CarRacing {
    private val recorder = CarRacingRecorder
    fun race(carNames: List<String>, tryCount: Int): CarRacingResult {
        val cars = carNames.map { Car(it) }
        val results = raceWithRecordResult(cars, tryCount)
        val winners = recorder.findWinners(cars)
        return CarRacingResult(cars, results, winners)
    }

    private fun raceWithRecordResult(cars: List<Car>, tryCount: Int): List<List<Car>> {
        return List(tryCount) {
            cars.racePerRound()
            recorder.recordRacingResultPerRound(cars)
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop(movableRange.random())
        }
    }

    companion object {
        private val movableRange = 0..9
    }
}
