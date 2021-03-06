package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.Car
import racingcar.racing.car.engine.Engine
import racingcar.racing.car.engine.Torque

internal class RacingTest {
    private val dummyEngine = object : Engine {
        override fun run() = Torque.STOP
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1])
    fun `참가 차량이 2대보다 적다면 IllegalArgumentException throw`(numberOfCars: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { Racing(1, generateCars(numberOfCars)) }
            .withMessage("At least two cars must be participated. count='$numberOfCars'")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -38])
    fun `시도 횟수는 1보다 작거나 같으면 IllegalArgumentException throw`(trials: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { Racing(trials, generateCars(2)) }
            .withMessage("The value of trials must be positive value.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 51])
    fun `시도 횟수만큼 RacingResults 내에 RacingTrial이 생긴다`(trials: Int) {
        val results = Racing(trials, generateCars(2)).start()
        assertThat(results.trials).hasSize(trials)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 5, 12])
    fun `차량 대수만큼 RacingTrial 내 CarLocation이 생긴다`(numberOfCars: Int) {
        val cars = generateCars(numberOfCars)

        val results = Racing(1, cars).start()
        assertThat(results.trials).allMatch { it.locations.size == numberOfCars }
    }

    private fun generateCars(numberOfCars: Int) = (1..numberOfCars).map { Car(dummyEngine) }
}
