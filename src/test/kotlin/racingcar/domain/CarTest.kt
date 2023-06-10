package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차의 초기위치는 0 이다`() {
        // given

        // when
        val sut = Car()

        // then
        assertThat(sut.location()).isEqualTo(0.toLocation())
    }

    @Test
    fun `차는 앞으로 이동할 수 있다`() {
        // given
        val sut = Car()

        // when
        sut.moveForward()

        // then
        assertThat(sut.location()).isEqualTo(1.toLocation())
    }
}