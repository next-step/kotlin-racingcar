package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import step2.Operator.Companion.convertToOperator

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `사칙연산 기호 테스트`(op: String) {
        assertThat(convertToOperator(op))
    }

    @ParameterizedTest
    @ValueSource(strings = ["%", "^", "&"])
    fun `지원하지 않는 기호 테스트`(op: String) {
        assertThatThrownBy { convertToOperator(op) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `덧셈 테스트`() {
        assertThat(convertToOperator("+").calculate(1, 3)).isEqualTo(4)
        assertThat(convertToOperator("+").calculate(6, 10)).isEqualTo(16)
        assertThat(convertToOperator("+").calculate(20, 100)).isEqualTo(120)
        assertThat(convertToOperator("+").calculate(123, 456)).isEqualTo(579)
    }

    @Test
    fun `뺼셈 테스트`() {
        assertThat(convertToOperator("-").calculate(3, 1)).isEqualTo(2)
        assertThat(convertToOperator("-").calculate(1, 3)).isEqualTo(-2)
        assertThat(convertToOperator("-").calculate(15, 10)).isEqualTo(5)
        assertThat(convertToOperator("-").calculate(123, 456)).isEqualTo(-333)
    }

    @Test
    fun `곱셈 테스트`() {
        assertThat(convertToOperator("*").calculate(3, 1)).isEqualTo(3)
        assertThat(convertToOperator("*").calculate(1, 3)).isEqualTo(3)
        assertThat(convertToOperator("*").calculate(15, 10)).isEqualTo(150)
        assertThat(convertToOperator("*").calculate(100, 45)).isEqualTo(4500)
    }

    @Test
    fun `나눗셈 테스트`() {
        assertThat(convertToOperator("/").calculate(3, 1)).isEqualTo(3)
        assertThat(convertToOperator("/").calculate(1, 3)).isEqualTo(0)
        assertThat(convertToOperator("/").calculate(220, 4)).isEqualTo(55)
        assertThat(convertToOperator("/").calculate(1000, 50)).isEqualTo(20)
    }

    @ParameterizedTest(name = "Test {index}: {0} / {1}")
    @CsvSource(value = ["2, 0", "40, 0", "100, 0"])
    fun `0으로 나누기 테스트`(value: Int, zero: Int) {
        assertThatThrownBy { convertToOperator("/").calculate(value, zero) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}