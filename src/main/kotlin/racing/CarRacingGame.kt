package racing

import racing.model.Car
import racing.model.CarInput
import racing.model.CarPositionHistory
import racing.model.PositionHistory

class CarRacingGame(private val carInput: CarInput) {
    private val carPositionHistory: CarPositionHistory

    init {
        carPositionHistory = initCarPositionHistory()
    }

    fun start(): CarPositionHistory {
        repeat(carInput.times) {
            carPositionHistory.play()
        }
        return carPositionHistory
    }

    private fun initCarPositionHistory(): CarPositionHistory {
        val tmpCarPositionHistory = LinkedHashMap<Car, PositionHistory>()
        repeat(carInput.carCount) {
            tmpCarPositionHistory[Car(START_POSITION)] = PositionHistory(mutableListOf())
        }

        return CarPositionHistory(tmpCarPositionHistory)
    }

    companion object {
        const val START_POSITION = 0
    }
}
