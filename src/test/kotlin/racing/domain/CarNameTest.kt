package racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarNameTest {
    @Test
    fun `constructor success`() {
        Assertions.assertThatCode { CarName("abcde") }.doesNotThrowAnyException()
    }

    @Test
    fun `constructor exception`() {
        Assertions.assertThatThrownBy { CarName("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
