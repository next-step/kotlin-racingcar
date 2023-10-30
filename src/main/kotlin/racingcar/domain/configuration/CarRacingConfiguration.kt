package racingcar.domain.configuration

import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.domain.car.CarName
import racingcar.view.CarRacingInput

class CarRacingConfiguration(
    val cars: List<Car>,
    val round: Int,
) {
    companion object {
        fun of(input: CarRacingInput): CarRacingConfiguration {
            return CarRacingConfiguration(
                cars = setCars(input.carNames),
                round = input.tryCount,
            )
        }

        private fun setCars(carNames: List<CarName>): List<Car> = CarGenerator.create(carNames)
    }
}
