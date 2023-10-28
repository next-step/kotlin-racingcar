package main

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @Test
    fun `연산자 종합 테스트`() {
        Assertions.assertThat(StringCalculator().run("1 + 3 / 2 * 4 - 1")).isEqualTo(7)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `Null or Empty String 전달 테스트`(formula: String?) {
        Assertions.assertThatThrownBy { StringCalculator().run(formula) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Formula should not be null or empty")
    }
}
