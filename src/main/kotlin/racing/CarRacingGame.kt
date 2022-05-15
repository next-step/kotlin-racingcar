package racing

import racing.model.Car
import racing.model.CarInput
import racing.model.Cars
import racing.model.TotalPositionHistory

class CarRacingGame(private val carInput: CarInput) {
    fun start(): TotalPositionHistory {
        val cars = makeCars()
        val totalPositionHistory = TotalPositionHistory(mutableListOf())

        repeat(carInput.times) {
            totalPositionHistory.save(cars.moveCars())
        }
        return totalPositionHistory
    }

    private fun makeCars(): Cars = Cars(List(carInput.carNames.size) { index -> Car(name = carInput.carNames[index]) })
}
