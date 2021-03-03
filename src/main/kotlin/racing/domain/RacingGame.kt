package racing.domain

import racing.data.RacingGameData
import racing.data.RacingHistory
import racing.data.RoundResult

class RacingGame(private val racingGameData: RacingGameData, movementChecker: MovementChecker) {

    val cars = Cars(racingGameData.carNames, movementChecker)

    fun run(): RacingHistory {
        val racingHistory = RacingHistory()
        repeat(racingGameData.tryCount) {
            cars.moveAllCar()
            val roundResult = RoundResult(cars.getCarStates())
            racingHistory.recordRoundResult(roundResult)
        }
        return racingHistory
    }

    fun getWinnerNames(): List<String> {
        return getWinners().map { it.name.name }.toList()
    }

    private fun getWinners(): List<Car> {
        return cars.getFarthestCars()
    }
}
