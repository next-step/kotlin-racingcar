package racingcar.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.Car
import racingcar.domain.car.CarAction
import racingcar.domain.car.Cars

internal class RacingCarGameTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 10])
    internal fun `경주 게임은 attemptCount만큼 진행된다`(attemptCount: Int) {
        val cars = Cars(
            cars = listOf(
                Car(name = "가", accelerator = { CarAction.MOVE }),
                Car(name = "나", accelerator = { CarAction.MOVE }),
            )
        )
        val carsHistory = RacingCarGame(
            originalCars = cars,
            attemptCount = attemptCount,
        ).play()
        assertThat(carsHistory.latest).allSatisfy {
            assertThat(it.movedDistance).isEqualTo(attemptCount)
        }
    }
}
