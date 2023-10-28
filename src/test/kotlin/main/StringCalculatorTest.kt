package main

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @Test
    fun `연산자 종합 테스트`() {
        Assertions.assertThat(StringCalculator().run("1 + 3 / 2 * 4 - 1")).isEqualTo(7)
    }

    @Test
    fun `빈 문자열 전달 테스트`() {
        Assertions.assertThatThrownBy { StringCalculator().run("  ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Formula should not be null or empty")
    }

    @Test
    fun `Null 전달 테스트`() {
        Assertions.assertThatThrownBy { StringCalculator().run(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Formula should not be null or empty")
    }
}
