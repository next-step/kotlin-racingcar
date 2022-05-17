package racingcar.ui

import racingcar.car.Car
import racingcar.car.RacingCar
import racingcar.engine.RandomEngine

data class GameInput(private val cars: Int, val round: Int) {
    fun toRacingCars(): List<Car> {
        require(round > 0) { "round 는 1 이상이어야 합니다" }
        require(cars > 0) { "자동차는 1대 이상이어야 합니다" }

        return List(cars) { RacingCar(RandomEngine()) }
    }
}
