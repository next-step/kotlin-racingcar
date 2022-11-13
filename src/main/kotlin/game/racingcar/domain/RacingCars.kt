package game.racingcar.domain

import game.racingcar.dto.CarLocation
import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy

class RacingCars(
    private val racingCars: List<RacingCar>
) {
    fun moveAll(): List<CarLocation> {
        return racingCars.onEach { it.move() }
            .map { CarLocation(it.name, it.location) }
    }

    fun pickWinners(): List<String> {
        return carsIn(getMaxLocation())
    }

    private fun carsIn(maxLocation: Int): List<String> = racingCars.filter { it.location == maxLocation }
        .map { it.name }

    private fun getMaxLocation(): Int = racingCars.maxOf { it.location }

    companion object {
        fun from(names: List<String>, moveStrategy: MoveStrategy = RandomMoveStrategy()): RacingCars {
            return RacingCars(
                names.map {
                    RacingCar(it, moveStrategy)
                }
            )
        }
    }
}
