package racingCar.lib

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ValidationTest {

    @Test
    fun `String 형태의 숫자를 입력하면 정수가 나온다`() {
        // when
        val result = Validation().isNumber("3")

        // then
        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `정수가 아닌 값을 입력하면 IllegalArgumentException를 던진다`() {
        // then
        assertThrows<IllegalArgumentException> {
            Validation().isNumber("A")
        }
    }
}