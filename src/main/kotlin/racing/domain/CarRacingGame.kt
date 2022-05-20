package racing.domain

import racing.domain.vo.CarInput

class CarRacingGame(private val carInput: CarInput) {
    fun start(): MoveResultHistory {
        val cars = CarFactory.makeCars(carInput.names)
        val history = (1..carInput.times.value).map { cars.moveCars() }
        return MoveResultHistory(history)
    }
}
