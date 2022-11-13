package racingcar.racingcar

class CarRacing(
    private val carManager: CarManager
) {
    fun participate(carRacingRequest: CarRacingRequest): CarRacingResult {
        val cars = carManager.ready(carRacingRequest.totalParticipants, carRacingRequest.turnCount)
        return start(cars, carRacingRequest.turnCount)
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
