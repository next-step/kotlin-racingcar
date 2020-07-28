package wk1_step4

import org.assertj.core.api.Assertions

class WinnerCarRacingTest {

    fun `test for car move or stop`() {
        Assertions.assertThatThrownBy {
            WinnerCarRacing.updateCarRacing(listOf())
        }.isInstanceOf(WinnerCarRacingException::class.java)
    }
}
