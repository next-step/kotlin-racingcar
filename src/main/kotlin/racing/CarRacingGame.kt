package racing

import racing.model.CarFactory
import racing.model.CarInput
import racing.model.MoveResultHistory

class CarRacingGame(private val carInput: CarInput) {
    fun start(): MoveResultHistory {
        val cars = CarFactory.makeCars(carInput.names)
        val history = (1..carInput.times.value).map { cars.moveCars() }
        return MoveResultHistory(history)
    }
}
