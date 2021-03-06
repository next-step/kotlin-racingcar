package racing.domain

import racing.data.CarState
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
            val carStates = cars.moveAllCar(movementChecker)
            recordRoundResult(carStates)
        }
    }

    private fun recordRoundResult(carStates: List<CarState>) {
        val roundResult = RoundResult(carStates)
        racingHistory.recordRoundResult(roundResult)
    }
}
