package racing

import racing.model.Car
import racing.model.CarInput
import racing.model.Cars
import racing.model.TotalPositionHistory

class CarRacingGame(private val carInput: CarInput) {
    fun start(): TotalPositionHistory {
        val cars = Cars(List(carInput.carCount) { Car(START_POSITION) })
        val totalPositionHistory = TotalPositionHistory(mutableListOf())

        repeat(carInput.times) {
            totalPositionHistory.save(cars.moveCars())
        }
        return totalPositionHistory
    }

    companion object {
        const val START_POSITION = 0
    }
}
