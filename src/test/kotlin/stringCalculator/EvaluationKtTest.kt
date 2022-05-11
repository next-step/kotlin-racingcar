package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class OperatorKtTest {

    @Test
    fun `1 과 2의 add 연산 결과가 3이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.add(1, 2)).isEqualTo(3)
    }

    @Test
    fun `6 과 4의 add 연산 결과가 10이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.add(6, 4)).isEqualTo(10)
    }

    @Test
    fun `1 과 2의 substract 연산 결과가 -1이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.substrate(1, 2)).isEqualTo(-1)
    }

    @Test
    fun `6 과 4의 substract 연산 결과가 2이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.substrate(6, 4)).isEqualTo(2)
    }

    @Test
    fun `1 과 2의 multiple 연산 결과가 2이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.multiple(1, 2)).isEqualTo(2)
    }

    @Test
    fun `6 과 4의 multiple 연산 결과가 24이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.multiple(6, 4)).isEqualTo(24)
    }

    @Test
    fun `1 과 2의 divide 연산 결과가 0이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.divide(1, 2)).isEqualTo(0)
    }


    @Test
    fun `6 과 4의 divide 연산 결과가 1이다`() {
        val eval = Evaluation()
        Assertions.assertThat(eval.divide(6, 4)).isEqualTo(1)
    }

    @Test
    fun `1과 0의 divide 연산 결과 div by zero로 ArithmeticException을 던진다`() {
        val eval = Evaluation()
        Assertions.assertThatThrownBy { eval.divide(1, 0) }
            .isInstanceOf(java.lang.ArithmeticException::class.java)
    }
}
