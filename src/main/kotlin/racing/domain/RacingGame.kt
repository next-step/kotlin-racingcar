package racing.domain

import racing.data.RacingGameData
import racing.data.RacingHistory
import racing.data.RoundResult
import racing.data.Winners

class RacingGame(private val racingGameData: RacingGameData, private val movementChecker: MovementChecker) {

    val cars: Cars = Cars(racingGameData.carNames)
    val racingHistory: RacingHistory = RacingHistory()
    val winners: Winners
        get() = Winners.from(cars.getFarthestCars())

    fun run() {
        repeat(racingGameData.tryCount) {
            cars.moveAllCar(movementChecker)
            recordCurrentState()
        }
    }

    private fun recordCurrentState() {
        val roundResult = RoundResult(cars.getCarStates())
        racingHistory.recordRoundResult(roundResult)
    }
}
