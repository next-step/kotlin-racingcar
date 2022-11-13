package racingcar.racingcar

class CarRacing {
    fun participate(cars: List<Car>, turnCount: Int): CarRacingResult {
        return start(cars, turnCount)
    }

    private fun start(cars: List<Car>, turnCount: Int): CarRacingResult {
        val carRacingResult = CarRacingResult()
        for (turn in 1..turnCount) {

            val turnRecord = cars.map {
                it.go(turn)
                it.currentLocation()
            }
            carRacingResult.record(TurnRecord(turn, turnRecord))
        }
        return carRacingResult
    }
}
