package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class EvaluationKtTest {

    @Test
    fun `add 연산자는 두 숫자를 합한다`() {
        val result = Evaluation.find("+").applyOperator(1, 2)
        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `substrate 연산자는 두 숫자를 뺀다`() {
        val result = Evaluation.find("-").applyOperator(1, 2)
        Assertions.assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `multiple 연산자는 두 숫자를 곱한다`() {
        val result = Evaluation.find("*").applyOperator(6, 4)
        Assertions.assertThat(result).isEqualTo(24)
    }

    @Test
    fun `divide 연산자는 두 숫자를 나눈다`() {
        val result = Evaluation.find("/").applyOperator(4, 2)
        Assertions.assertThat(result).isEqualTo(2)
    }

    @Test
    fun `1과 0의 divide 연산 결과 div by zero로 ArithmeticException을 던진다`() {
        Assertions.assertThatThrownBy { Evaluation.find("/").applyOperator(3, 0) }
            .isInstanceOf(java.lang.ArithmeticException::class.java)
    }
}
