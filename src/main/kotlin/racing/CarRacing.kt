package racing

class CarRacing {
    private val recorder = CarRacingRecorder()
    fun race(cars: List<Car>, tryCount: Int): CarRacingResult {
        val results = cars.race(tryCount)
        val winners = recorder.findWinners(cars)
        return CarRacingResult(results, winners)
    }

    private fun List<Car>.race(tryCount: Int): List<List<Car>> {
        return List(tryCount) {
            racePerRound()
            recorder.recordRacingResultPerRound(cars = this)
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
