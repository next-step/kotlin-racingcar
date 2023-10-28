package racingcar.domain

import racingcar.view.CarRacingInput
import java.lang.IllegalArgumentException

class CarRacingConfiguration(
    val carCount: Int,
    val roundCount: Int,
) {
    private val cars: List<Car> by lazy { setCars() }
    private val rounds: IntRange by lazy { setRounds() }

    fun getCarRacingGameConfiguration(): CarRacingGameConfiguration =
        CarRacingGameConfiguration(
            cars = cars,
            rounds = rounds,
        )

    fun getCarRacingResultConfiguration(): CarRacingResultConfiguration =
        CarRacingResultConfiguration(
            rounds = rounds,
        )

    fun getRoundResultConfiguration(): RoundResultConfiguration =
        RoundResultConfiguration(
            cars = cars
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
            require(input > 0) { throw IllegalArgumentException("갯수는 0보다 커야 합니다") }
            return input
        }
    }
}

data class CarRacingGameConfiguration(
    val cars: List<Car>,
    val rounds: IntRange,
)

data class CarRacingResultConfiguration(
    val rounds: IntRange,
)

data class RoundResultConfiguration(
    val cars: List<Car>
)
