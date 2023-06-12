package study

import domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 전진 성공`() {
        assertThat(Car().move(true)).isEqualTo(1)
    }

    @Test
    fun `자동차 전진 실패`() {
        assertThat(Car().move(false)).isEqualTo(0)
    }

}
