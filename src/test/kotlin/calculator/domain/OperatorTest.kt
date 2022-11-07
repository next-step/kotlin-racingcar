package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {

    @DisplayName("지정되지 않은 수식이 들어갈시 에러 반환")
    @Test
    fun `지정되지 않은 수식이 들어갈 시 에러 반환`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Operator.from("$") }
            .withMessage("올바르지 않은 연산자 입니다")
    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(
        "1 + 1=2.0",
        "2 - 1=1.0",
        "2 * 2=4.0",
        "2 / 2=1.0",
        delimiter = '='
    )
    fun `사칙연산 테스트`(input: String, expected: Double) {
        val arr = input.split(" ")

        val result = Operator.from(arr[1]).apply(arr[0].toDouble(), arr[2].toDouble())

        assertThat(result).isEqualTo(expected)
    }
}
