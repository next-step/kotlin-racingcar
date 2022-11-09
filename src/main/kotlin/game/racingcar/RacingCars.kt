package game.racingcar

import game.racingcar.dto.CarLocation
import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy

class RacingCars(
    carNames: List<String>,
    moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    private val racingCars = carNames.map { RacingCar(it, moveStrategy) }

    fun moveAll(): List<CarLocation> {
        return racingCars.onEach { it.move() }
            .map { CarLocation(it.name, it.location) }
    }

    fun pickWinners(): List<String> {
        return carsIn(getMaxLocation())
    }

    private fun carsIn(maxLocation: Int) = racingCars.filter { it.location == maxLocation }.map { it.name }

    private fun getMaxLocation() = racingCars.maxOf { it.location }
}
