package racingcar.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.MoveCarAccelerator

internal class RacingCarGameTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 10])
    internal fun `경주 게임은 attemptCount만큼 진행된다`(attemptCount: Int) {
        val cars = Cars(
            cars = listOf(
                Car(name = "가", accelerator = MoveCarAccelerator),
                Car(name = "나", accelerator = MoveCarAccelerator),
            )
        )
        RacingCarGame(
            cars = cars,
            attemptCount = attemptCount,
            onEachRace = {}
        ).play()
        assertThat(cars).allSatisfy {
            assertThat(it.movedDistance()).isEqualTo(attemptCount)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 10])
    internal fun `경주 게임이 진행될때마다 car가 움직인 거리를 계산할 수 있다`(attemptCount: Int) {
        val cars = Cars(listOf(Car(name = "가", accelerator = MoveCarAccelerator)))
        var attemptCounter = 0
        RacingCarGame(
            cars = cars,
            attemptCount = attemptCount,
            onEachRace = {
                attemptCounter += 1
                assertThat(it).allSatisfy { car ->
                    assertThat(car.movedDistance()).isEqualTo(attemptCounter)
                }
            }
        ).play()
    }
}
