package study.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingCarTest {

    @Test
    fun `Car의 moved 초기 값은 0이다`() {
        val racingCar = RacingCar()

        assertThat(racingCar.getMoved()).isEqualTo(0)
    }

    @Test
    fun `Car는 go 할 수 있다`() {
        val racingCar = RacingCar()

        val moved = racingCar.go()

        assertThat(moved).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 10])
    fun `n회 움직일 수 있다`(times: Int) {
        val racingCar = RacingCar()

        val moved = racingCar.goTimes(times)

        assertThat(moved).isEqualTo(times)
    }
}