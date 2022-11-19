package racingcar.controller.dto

import racingcar.domain.Car

data class GameResults private constructor(val carPositions: List<Int>) {

    companion object {
        fun of(cars: List<Car>) = GameResults(cars.map { it.position.position }.toList())
    }
}
