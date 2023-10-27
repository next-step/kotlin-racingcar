package racingcar.domain

import racingcar.view.CarRacingInput
import java.lang.IllegalArgumentException

data class CarRacingInitialConfiguration(
    val carCount: Int,
    val tryCount: Int,
) {
    companion object {
        fun of(input: CarRacingInput): CarRacingInitialConfiguration = CarRacingInitialConfiguration(
            carCount = validateCount(input.carCount),
            tryCount = validateCount(input.tryCount),
        )

        private fun validateCount(input: Int): Int {
            require(input > 0) { throw IllegalArgumentException("갯수는 0보다 커야 합니다") }
            return input
        }
    }
}
