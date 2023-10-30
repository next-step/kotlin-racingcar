package racingcar.domain.configuration

import racingcar.domain.CarRacingInputValidator
import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.view.CarRacingInput

class CarRacingConfiguration(
    val cars: List<Car>,
    val round: Int,
) {
    companion object {
        fun of(input: CarRacingInput): CarRacingConfiguration {
            val carCount = CarRacingInputValidator.validateCount(input.carCount)
            val roundCount = CarRacingInputValidator.validateCount(input.tryCount)
            return CarRacingConfiguration(
                cars = setCars(carCount),
                round = roundCount,
            )
        }

        private fun setCars(carCount: Int): List<Car> = CarGenerator.createInOrder(carCount)
    }
}
