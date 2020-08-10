package calculator.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class TextCalculatorTest {

    @Test
    fun `calculate() 예제 실행 테스트`() {
        assertThat(
            TextCalculator().calculate(
                listOf(
                    Number(2.0),
                    Operator.PLUS,
                    Number(3.0),
                    Operator.MULTIPLY,
                    Number(4.0),
                    Operator.DIVIDE,
                    Number(2.0)
                )
            )
        ).isEqualTo(10)
    }

    @Test
    fun `calculate() 처음에 나눠서 0보다 작은 수로 시작하는 경우 검증`() {
        assertThat(
            TextCalculator().calculate(
                listOf(
                    Number(2.0),
                    Operator.DIVIDE,
                    Number(16.0),
                    Operator.MULTIPLY,
                    Number(2.0),
                    Operator.MULTIPLY,
                    Number(2.0),
                    Operator.MULTIPLY,
                    Number(2.0)
                )
            )
        ).isEqualTo(1)
    }

    @Test
    fun `calculate() 0으로 나누면 DivideByZeroException 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(
                    listOf(
                        Number(1.0),
                        Operator.DIVIDE,
                        Number(0.0)
                    )
                )
            )
        }.isInstanceOf(Operator.DivideByZeroException::class.java)
    }

    @Test
    fun `calculate() 숫자만 연속으로 있으면 OperatorIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(
                    listOf(
                        Number(1.0),
                        Number(0.0),
                        Operator.PLUS,
                        Number(0.0)
                    )
                )
            )
        }.isInstanceOf(TextCalculator.OperatorIsMissing::class.java)
    }

    @Test
    fun `calculate() 연산자로 시작하면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(
                    listOf(
                        Operator.PLUS,
                        Number(0.0),
                        Number(1.0)
                    )
                )
            )
        }.isInstanceOf(TextCalculator.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 비어있는 리스트라면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(listOf())
            )
        }.isInstanceOf(TextCalculator.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 연산자로 끝나면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(
                    listOf(
                        Number(1.0),
                        Operator.PLUS,
                        Number(1.0),
                        Operator.MULTIPLY
                    )
                )
            )
        }.isInstanceOf(TextCalculator.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 연산자가 연속으로 나오면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(
                    listOf(
                        Number(1.0),
                        Operator.PLUS,
                        Operator.MULTIPLY,
                        Number(1.0)
                    )
                )
            )
        }.isInstanceOf(TextCalculator.NumberIsMissing::class.java)
    }
}
