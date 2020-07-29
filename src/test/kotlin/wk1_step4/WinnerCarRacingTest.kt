package wk1_step4

import org.assertj.core.api.Assertions.assertThatThrownBy

class WinnerCarRacingTest {

    fun `test for car move or stop`() {
        assertThatThrownBy {
            WinnerCarRacing.updateCarRacing(listOf())
        }.isInstanceOf(WinnerCarRacingException::class.java)
    }
}
