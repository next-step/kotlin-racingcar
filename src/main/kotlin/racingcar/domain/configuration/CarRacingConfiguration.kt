package racingcar.domain.configuration

import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.view.CarRacingInput

class CarRacingConfiguration(
    val carCount: Int,
    val roundCount: Int,
) {
    private val cars: List<Car> by lazy { setCars() }
    private val rounds: IntRange by lazy { setRounds() }

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

    private fun setCars(): List<Car> = CarGenerator.createInOrder(carCount)

    private fun setRounds(): IntRange = (CAR_RACING_INITIAL_ROUND..roundCount)

    companion object {
        private const val CAR_RACING_INITIAL_ROUND = 1
        fun of(input: CarRacingInput): CarRacingConfiguration = CarRacingConfiguration(
            carCount = validateCount(input.carCount),
            roundCount = validateCount(input.tryCount),
        )

        private fun validateCount(input: Int): Int {
            require(input > 0) { "갯수는 0보다 커야 합니다" }
            return input
        }
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
