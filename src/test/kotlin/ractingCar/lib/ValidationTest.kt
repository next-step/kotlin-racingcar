package ractingCar.lib

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ValidationTest {

    @Test
    fun `"3"을 입력하면 3이 나온다`() {
        // when
        val result = Validation().isNumber("3")

        // then
        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `"a"을 입력하면 IllegalArgumentException를 던진다`() {
        // then
        assertThrows<IllegalArgumentException> {
            Validation().isNumber("A")
        }
    }
}