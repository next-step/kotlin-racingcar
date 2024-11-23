package misson

import misson.car.domain.RacingCar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest {
    @Test
    fun `이름이 5자를 초과하면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> { RacingCar("1234567") }.message)
            .isEqualTo("이름은 5자 이하만 가능합니다.")
    }

    @Test
    fun `이름이 빈 문자열이면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> { RacingCar("") }.message)
            .isEqualTo("이름은 공백일 수 없습니다.")
    }

    @Test
    fun `랜덤 값이 4이상일때 전진한다`() {
        RacingCar().apply {
            move { 4 }
            assertThat(position).isEqualTo(1)
        }
    }

    @Test
    fun `랜덤 값이 4보다 작으면 전진하지 않는다`() {
        RacingCar().apply {
            move { 3 }
            assertThat(position).isEqualTo(0)
        }
    }
}
