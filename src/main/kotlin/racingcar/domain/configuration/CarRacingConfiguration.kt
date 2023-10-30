package racingcar.domain.configuration

import racingcar.domain.CarRacingInputValidator
import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.view.CarRacingInput

class CarRacingConfiguration(
    val cars: List<Car>,
    val rounds: IntRange
) {
    companion object {
        private const val CAR_RACING_INITIAL_ROUND = 1
        fun of(input: CarRacingInput): CarRacingConfiguration {
            val carCount = CarRacingInputValidator.validateCount(input.carCount)
            val roundCount = CarRacingInputValidator.validateCount(input.tryCount)
            return CarRacingConfiguration(
                cars = setCars(carCount),
                rounds = setRounds(roundCount),
            )
        }

        private fun setCars(carCount: Int): List<Car> = CarGenerator.createInOrder(carCount)

        private fun setRounds(roundCount: Int): IntRange = (CAR_RACING_INITIAL_ROUND..roundCount)
    }
}
