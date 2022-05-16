package racing

import racing.model.Car
import racing.model.CarInput
import racing.model.Cars
import racing.model.Position
import racing.model.PositionHistory
import racing.model.TotalPositionHistory

class CarRacingGame(private val carInput: CarInput) {
    fun start(): TotalPositionHistory {
        val cars = makeCars()
        val totalPositionHistory = mutableListOf<PositionHistory>()

        repeat(carInput.times.times) {
            totalPositionHistory.add(cars.moveCars())
        }
        return TotalPositionHistory(totalPositionHistory.toList())
    }

    private fun makeCars(): Cars {
        val cars = mutableListOf<Car>()
        carInput.names.forEach { name ->
            cars.add(Car(name, Position()))
        }
        return Cars(cars.toList())
    }
}
