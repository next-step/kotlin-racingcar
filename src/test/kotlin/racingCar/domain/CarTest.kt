package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `position 초기값 테스트`() {
        val actual = Car()
        assertThat(actual.position).isEqualTo(0)
    }

    @Test
    fun `move 동작 테스트`() {
        val actual = Car()
        actual.move()
        assertThat(actual.position).isEqualTo(1)
    }
}
