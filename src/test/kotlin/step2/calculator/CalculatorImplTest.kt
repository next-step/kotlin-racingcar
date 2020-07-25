package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class CalculatorImplTest {

    @Test
    fun `calculate() 예제 실행 테스트`() {
        assertThat(
            CalculatorImpl().calculate(
                listOf(
                    Node.Number(2.0),
                    Node.Operator.Plus,
                    Node.Number(3.0),
                    Node.Operator.Multiply,
                    Node.Number(4.0),
                    Node.Operator.Divide,
                    Node.Number(2.0)
                )
            )
        ).isEqualTo(10)
    }

    @Test
    fun `calculate() 0으로 나누면 DivideByZeroException 발생`() {
        assertThatThrownBy {
            assertThat(
                CalculatorImpl().calculate(
                    listOf(
                        Node.Number(1.0),
                        Node.Operator.Divide,
                        Node.Number(0.0)
                    )
                )
            )
        }.isInstanceOf(Node.Operator.Divide.DivideByZeroException::class.java)
    }

    @Test
    fun `calculate() 숫자만 연속으로 있으면 OperatorIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                CalculatorImpl().calculate(
                    listOf(
                        Node.Number(1.0),
                        Node.Number(0.0),
                        Node.Operator.Plus,
                        Node.Number(0.0)
                    )
                )
            )
        }.isInstanceOf(Calculator.Error.OperatorIsMissing::class.java)
    }

    @Test
    fun `calculate() 연산자로 시작하면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                CalculatorImpl().calculate(
                    listOf(
                        Node.Operator.Plus,
                        Node.Number(0.0),
                        Node.Number(1.0)
                    )
                )
            )
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 비어있는 리스트라면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                CalculatorImpl().calculate(listOf())
            )
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 연산자로 끝나면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                CalculatorImpl().calculate(
                    listOf(
                        Node.Number(1.0),
                        Node.Operator.Plus,
                        Node.Number(1.0),
                        Node.Operator.Multiply
                    )
                )
            )
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `calculate() 연산자가 연속으로 나오면 NumberIsMissing 발생`() {
        assertThatThrownBy {
            assertThat(
                CalculatorImpl().calculate(
                    listOf(
                        Node.Number(1.0),
                        Node.Operator.Plus,
                        Node.Operator.Multiply,
                        Node.Number(1.0)
                    )
                )
            )
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `getNumber() 해당 인덱스에 Number가 있을 때`() {
        val list = listOf<Node>(
            Node.Number(0.0),
            Node.Number(1.0),
            Node.Number(2.0),
            Node.Number(3.0)
        )
        CalculatorImpl().apply {
            assertThat(list.getNumber(0)).isEqualTo(Node.Number(0.0))
            assertThat(list.getNumber(1)).isEqualTo(Node.Number(1.0))
            assertThat(list.getNumber(2)).isEqualTo(Node.Number(2.0))
            assertThat(list.getNumber(3)).isEqualTo(Node.Number(3.0))
        }
    }

    @Test
    fun `getNumber() 해당 인덱스가 list의 범위안에 없을 때 NumberIsMissing`() {
        val empty = listOf<Node>()
        val list = listOf<Node>(Node.Number(1.0))
        assertThatThrownBy {
            CalculatorImpl().apply {
                assertThat(empty.getNumber(0))
            }
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
        assertThatThrownBy {
            CalculatorImpl().apply {
                assertThat(list.getNumber(1))
            }
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `getNumber() 해당 인덱스에 Operator가 들어있을 때 NumberIsMissing`() {
        val list = listOf<Node>(
            Node.Operator.Plus
        )
        assertThatThrownBy {
            CalculatorImpl().apply {
                assertThat(list.getNumber(0))
            }
        }.isInstanceOf(Calculator.Error.NumberIsMissing::class.java)
    }

    @Test
    fun `getOperator() 해당 인덱스에 Operator가 있을 때`() {
        val list = listOf<Node>(
            Node.Operator.Plus,
            Node.Operator.Minus,
            Node.Operator.Multiply,
            Node.Operator.Divide
        )
        CalculatorImpl().apply {
            assertThat(list.getOperator(0)).isEqualTo(Node.Operator.Plus)
            assertThat(list.getOperator(1)).isEqualTo(Node.Operator.Minus)
            assertThat(list.getOperator(2)).isEqualTo(Node.Operator.Multiply)
            assertThat(list.getOperator(3)).isEqualTo(Node.Operator.Divide)
        }
    }

    @Test
    fun `getOperator() 해당 인덱스가 list의 범위안에 없을 때 OperatorIsMissing`() {
        val empty = listOf<Node>()
        assertThatThrownBy {
            CalculatorImpl().apply {
                assertThat(empty.getOperator(0))
            }
        }.isInstanceOf(Calculator.Error.OperatorIsMissing::class.java)
    }

    @Test
    fun `getOperator() 해당 인덱스에 Number가 들어있을 때 OperatorIsMissing`() {
        val list = listOf<Node>(
            Node.Number(0.0)
        )
        assertThatThrownBy {
            CalculatorImpl().apply {
                assertThat(list.getOperator(0))
            }
        }.isInstanceOf(Calculator.Error.OperatorIsMissing::class.java)
    }
}
