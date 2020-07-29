package wk1_step4

import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.NullPointerException

class WinnerCarRacingTest {

    fun `test for update car racing`() {
        assertThatThrownBy {
            WinnerCarRacing.updateCarRacing(listOf())
        }.isInstanceOf(WinnerCarRacingException::class.java)
    }

    fun `test for car move or stop`() {
        assertThatThrownBy {
            WinnerCarRacing.updateCarRacing(listOfNotNull())
        }.isInstanceOf(NullPointerException::class.java)
    }
}
