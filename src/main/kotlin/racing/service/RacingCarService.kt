package racing.service

import racing.domain.Car
import racing.domain.CarNameMapper
import racing.domain.MoveCondition
import racing.domain.Racing

class RacingCarService(private val carNameMapper: CarNameMapper = CarNameMapper) {
    fun prepareRacingGame(carNames: List<String>): List<Car> {
        return carNameMapper.map(carNames)
    }

    fun startRacingGame(cars: List<Car>): List<Car> {
        val racing = Racing(cars)
        return racing.startRacing { MoveCondition.movable() }
    }
}
