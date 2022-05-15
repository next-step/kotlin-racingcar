package racingcar.ui

import racingcar.car.Car
import racingcar.car.RacingCar
import racingcar.engine.RandomEngine

class GameInput(private val cars: Int, val round: Int) {
    fun toRacingCars(): List<Car> {
        return List(cars) { RacingCar(RandomEngine()) }
    }
}
