package racingcar.domain.configuration

import racingcar.domain.CarRacingInputValidator
import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.view.CarRacingInput

class CarRacingConfiguration(
    private val cars: List<Car>,
    private val rounds: IntRange
) {
    fun getCarRacingGameConfiguration(): CarRacingGameConfiguration =
        CarRacingGameConfiguration(
            cars = cars,
            roundRange = rounds,
        )

    fun getCarRacingResultConfiguration(): CarRacingResultConfiguration =
        CarRacingResultConfiguration(
            cars = cars,
            roundRange = rounds,
        )

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

data class CarRacingGameConfiguration(
    val cars: List<Car>,
    val roundRange: IntRange,
)

data class CarRacingResultConfiguration(
    val cars: List<Car>,
    val roundRange: IntRange,
)
