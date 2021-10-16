package domain.step3.domain.racingcar

import domain.step3.domain.strategy.MovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarTest {

    @Test
    fun `RacingCar 조건 만족시 주행거리 테스트`() {
        val racingCar = RacingCar { true }
        val movedRacingCar = racingCar.move()

        assertThat(movedRacingCar.distance).isEqualTo(1)
    }

    @Test
    fun `RacingCar 조건 불만족시 주행거리 테스트`() {
        val racingCar = RacingCar { false }
        val movedRacingCar = racingCar.move()

        assertThat(movedRacingCar.distance).isEqualTo(0)
    }

    @Test
    fun `RacingCar hashCode 및 equals 테스트`() {
        val movingStrategy = MovingStrategy { true }
        val one = RacingCar(movingStrategy = movingStrategy)
        val other = RacingCar(movingStrategy = movingStrategy)

        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) }
        )
    }
}
