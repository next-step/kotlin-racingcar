package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.Pedal

class PedalTest {
    @Test
    fun `무조건 전진되는 테스트`() {
        val pedal = Pedal(0)

        assertThat(pedal.press()).isTrue
    }

    @Test
    fun `무조건 멈추는 테스트`() {
        val pedal = Pedal(10)

        assertThat(pedal.press()).isFalse
    }
}
