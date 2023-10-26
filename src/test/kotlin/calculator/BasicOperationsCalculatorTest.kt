package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasicOperationsCalculatorTest {

    @Test
    fun add() {
        // given
        val firstNum: Double = 10.0
        val secondNum: Double = 5.0

        // when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val result = basicOperationsCalculator.add(firstNum, secondNum)

        // then
        assertThat(result).isEqualTo(firstNum + secondNum)
    }

    @Test
    fun subtract() {
        // given
        val firstNum: Double = 10.0
        val secondNum: Double = 5.0

        // when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val result = basicOperationsCalculator.subtract(firstNum, secondNum)

        // then
        assertThat(result).isEqualTo(firstNum - secondNum)
    }

    @Test
    fun multiply() {
        // given
        val firstNum: Double = 10.0
        val secondNum: Double = 5.0

        // when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val result = basicOperationsCalculator.multiply(firstNum, secondNum)

        // then
        assertThat(result).isEqualTo(firstNum * secondNum)
    }

    @Test
    fun divide() {
        // given
        val firstNum: Double = 10.0
        val secondNum: Double = 5.0

        // when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val result = basicOperationsCalculator.divide(firstNum, secondNum)

        // then
        assertThat(result).isEqualTo(firstNum / secondNum)
    }

    @Test
    fun operation(){
        // given
        val firstNum: Double = 10.0
        val secondNum: Double = 5.0

        // when
        val basicOperationsCalculator = BasicOperationsCalculator()
        val plusResult = basicOperationsCalculator.operation(firstNum, secondNum, "+")
        val minusResult = basicOperationsCalculator.operation(firstNum, secondNum, "-")
        val multiplyResult = basicOperationsCalculator.operation(firstNum, secondNum, "*")
        val divideResult = basicOperationsCalculator.operation(firstNum, secondNum, "/")

        // then
        assertThat(plusResult).isEqualTo(firstNum + secondNum)
        assertThat(minusResult).isEqualTo(firstNum - secondNum)
        assertThat(multiplyResult).isEqualTo(firstNum * secondNum)
        assertThat(divideResult).isEqualTo(firstNum / secondNum)
    }
}