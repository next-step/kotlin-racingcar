package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarTest {

    @Test
    fun `RacingCar 가 조건을 만족한다면 1칸 이동한다`() {
        val name = Name("test")
        val racingCar = RacingCar(name) { true }
        val movedRacingCar = racingCar.moveForward()

        assertThat(movedRacingCar.distance).isEqualTo(1)
    }

    @Test
    fun `RacingCar 가 조건을 불만족시한다면 이동하지 않는다`() {
        val name = Name("test")
        val racingCar = RacingCar(name) { false }
        val movedRacingCar = racingCar.moveForward()

        assertThat(movedRacingCar.distance).isEqualTo(0)
    }

    @Test
    fun `동일한 주행거리와 움직임 전략을 갖고 있다면 동일한 객체이다`() {
        val name = Name("test")
        val movingStrategy = MovingStrategy { true }
        val one = RacingCar(name, movingStrategy = movingStrategy)
        val other = RacingCar(name, movingStrategy = movingStrategy)

        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) }
        )
    }
}
