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
    fun `move 동작 테스트 - 값이 4 이상인 경우 차가 앞으로 이동`() {
        val actual = Car()
        actual.move(4)
        assertThat(actual.position).isEqualTo(1)
    }

    @Test
    fun `move 동작 테스트 - 값이 3 이하인 경우 차가 이동하지 않음`() {
        val actual = Car()
        actual.move(1)
        assertThat(actual.position).isEqualTo(0)
    }
}
