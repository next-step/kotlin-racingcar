package racing.domain

import racing.data.CarState
import racing.data.RacingGameData
import racing.data.RacingGameResult
import racing.data.RacingHistory
import racing.data.RoundResult
import racing.data.Winners

class RacingGame(private val racingGameData: RacingGameData, private val movementChecker: MovementChecker) {

    val cars: Cars = Cars(racingGameData.carNames)
    private val racingHistory: RacingHistory = RacingHistory()

    fun run(): RacingGameResult {
        repeat(racingGameData.tryCount) {
            val carStates = cars.moveAllCar(movementChecker)
            recordRoundResult(carStates)
        }

        val winners = findWinners()
        return RacingGameResult(racingHistory, winners)
    }

    private fun recordRoundResult(carStates: List<CarState>) {
        val roundResult = RoundResult(carStates)
        racingHistory.recordRoundResult(roundResult)
    }

    private fun findWinners(): Winners {
        return Winners.from(cars.getFarthestCars())
    }
}
