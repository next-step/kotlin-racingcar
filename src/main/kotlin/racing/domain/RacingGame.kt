package racing.domain

import racing.data.RacingGameData
import racing.data.RacingHistory
import racing.data.RoundResult
import racing.data.Winners

class RacingGame(private val racingGameData: RacingGameData, private val movementChecker: MovementChecker) {

    val cars = Cars(racingGameData.carNames)
    val racingHistory = RacingHistory()

    fun run() {
        repeat(racingGameData.tryCount) {
            cars.moveAllCar(movementChecker)
            recordCurrentState()
        }
    }

    fun getWinners(): Winners {
        return Winners.from(cars.getFarthestCars())
    }

    private fun recordCurrentState() {
        val roundResult = RoundResult(cars.getCarStates())
        racingHistory.recordRoundResult(roundResult)
    }
}
