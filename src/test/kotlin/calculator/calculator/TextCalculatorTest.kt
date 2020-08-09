package calculator.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
        }.isInstanceOf(Calculator.Error.OperatorIsMissing::class.java)
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
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 비어있는 리스트라면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                TextCalculator().calculate(listOf())
            )
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
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
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
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
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `getNumber() 해당 인덱스에 Number가 있을 때`() {
        val list = listOf<Node>(
            Number(0.0),
            Number(1.0),
            Number(2.0),
            Number(3.0)
        )
        TextCalculator().apply {
            assertThat(list.getNumber(0)).isEqualTo(Number(0.0))
            assertThat(list.getNumber(1)).isEqualTo(Number(1.0))
            assertThat(list.getNumber(2)).isEqualTo(Number(2.0))
            assertThat(list.getNumber(3)).isEqualTo(Number(3.0))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `getNumber() 해당 인덱스가 list의 범위안에 없을 때 NumberIsMissing`(number: Int) {
        val empty = listOf<Node>()
        val list = listOf<Node>(Number(1.0))
        assertThatThrownBy {
            TextCalculator().apply {
                assertThat(empty.getNumber(number))
            }
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `getNumber() 해당 인덱스에 Operator가 들어있을 때 NumberIsMissing`() {
        val list = listOf<Node>(
            Operator.PLUS
        )
        assertThatThrownBy {
            TextCalculator().apply {
                assertThat(list.getNumber(0))
            }
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `getOperator() 해당 인덱스에 Operator가 있을 때`() {
        val list = listOf<Node>(
            Operator.PLUS,
            Operator.MINUS,
            Operator.MULTIPLY,
            Operator.DIVIDE
        )
        TextCalculator().apply {
            assertThat(list.getOperator(0)).isEqualTo(Operator.PLUS)
            assertThat(list.getOperator(1)).isEqualTo(Operator.MINUS)
            assertThat(list.getOperator(2)).isEqualTo(Operator.MULTIPLY)
            assertThat(list.getOperator(3)).isEqualTo(Operator.DIVIDE)
        }
    }

    @Test
    fun `getOperator() 해당 인덱스가 list의 범위안에 없을 때 OperatorIsMissing`() {
        val empty = listOf<Node>()
        assertThatThrownBy {
            TextCalculator().apply {
                assertThat(empty.getOperator(0))
            }
        }.isInstanceOf(Calculator.Error.OperatorIsMissing::class.java)
    }

    @Test
    fun `getOperator() 해당 인덱스에 Number가 들어있을 때 OperatorIsMissing`() {
        val list = listOf<Node>(
            Number(0.0)
        )
        assertThatThrownBy {
            TextCalculator().apply {
                assertThat(list.getOperator(0))
            }
        }.isInstanceOf(Calculator.Error.OperatorIsMissing::class.java)
    }
}
