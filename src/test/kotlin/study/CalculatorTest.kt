package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import study.racingcar.step2.Calculator
import study.racingcar.step2.operation.DivisionCalculation
import study.racingcar.step2.operation.MinusCalculation
import study.racingcar.step2.operation.MultiplicationCalculation
import study.racingcar.step2.operation.PlusCalculation

class CalculatorTest {

    @Test
    fun `예외 Test`() {
        assertThrows<IllegalArgumentException> {
            PlusCalculation().calculate("", "2")
        }
    }

    @Test
    fun `단위 클래스 Test`() {
        assertAll(
            { Assertions.assertThat(PlusCalculation().calculate("1", "2")).isEqualTo(3) },
            { Assertions.assertThat(MinusCalculation().calculate("5", "2")).isEqualTo(3) },
            { Assertions.assertThat(DivisionCalculation().calculate("4", "2")).isEqualTo(2) },
            { Assertions.assertThat(MultiplicationCalculation().calculate("4", "2")).isEqualTo(8) }
        )
    }

    @Test
    fun `더하기`() {
        val calculation = Calculator().expression("1 + 2").calculation()
        Assertions.assertThat(calculation).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        val calculation = Calculator().expression("1 - 2").calculation()
        Assertions.assertThat(calculation).isEqualTo(-1)
    }

    @Test
    fun `나누기`() {
        val calculation = Calculator().expression("10 / 2").calculation()
        Assertions.assertThat(calculation).isEqualTo(5)
    }

    @Test
    fun `곱하기`() {
        val calculation = Calculator().expression("5 * 2").calculation()
        Assertions.assertThat(calculation).isEqualTo(10)
    }

    @Test
    fun `계산식 Test`() {
        val expression = "2 + 3 * 4 / 2"
        val calculation = Calculator().expression(expression).calculation()
        Assertions.assertThat(calculation).isEqualTo(10)
    }
}
