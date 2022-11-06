package racingcar.racingcar

import racingcar.util.RandomUtil

class CarRacing(
    private val carManager: CarManager
) {
    fun participate(carRacingRequest: CarRacingRequest): CarRacingResult {
        val cars = carManager.ready(carRacingRequest.totalParticipants)
        return racing(cars, carRacingRequest.tryCount)
    }

    private fun racing(cars: List<Car>, tryCount: Int): CarRacingResult {
        val carRacingResult = CarRacingResult()
        for (i in 1..tryCount) {
            val result = cars.map {
                val randomNumber = RandomUtil.generateRandomNumber(0, 9)
                it.go(randomNumber)
                it.currentLocation()
            }
            carRacingResult.record(result)
        }
        return carRacingResult
    }
}
