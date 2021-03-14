package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.Car
import racingcar.domain.car.CarName
import racingcar.domain.car.engine.Engine
import racingcar.domain.car.engine.Torque

internal class RacingTest {
    private val dummyEngine = object : Engine {
        override fun run() = Torque.STOP
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1])
    fun `참가 차량이 2대보다 적다면 IllegalArgumentException을 던진다`(numberOfCars: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { Racing(1, generateCars(numberOfCars)) }
            .withMessage("At least two cars must be participated. count='$numberOfCars'")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -38])
    fun `시도 횟수는 1보다 작거나 같으면 IllegalArgumentException을 던진다`(trials: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { Racing(trials, generateCars(2)) }
            .withMessage("The value of trials must be positive value.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 51])
    fun `시도 횟수만큼 경주 결과(RacingResults) 내에 경주 시도(RacingTrial)가 생긴다`(trials: Int) {
        val results = Racing(trials, generateCars(2)).start()
        assertThat(results.trials).hasSize(trials)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 5, 12])
    fun `경주 시도(RacingTrial) 내에 기록(Record)의 개수는 차량 대수와 동일하다`(numberOfCars: Int) {
        val cars = generateCars(numberOfCars)

        val results = Racing(1, cars).start()
        assertThat(results.trials).allMatch { it.records.size == numberOfCars }
    }

    private fun generateCars(numberOfCars: Int) = (1..numberOfCars).map { Car(CarName("슈마허"), dummyEngine) }
}
