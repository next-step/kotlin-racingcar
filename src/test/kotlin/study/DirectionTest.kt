package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class DirectionTest {

    @Test
    fun plus_minus_multiplication_division() {
        val numList = listOf(2, 1)
        val direction = Direction

        val plus = direction.plus(numList)
        val minus = direction.minus(numList[0], numList[1])
        val multiplication = direction.multiplication(numList[0], numList[1])
        val division = direction.division(numList[0], numList[1])

        assertThat(plus).isEqualTo(3)
        assertThat(minus).isEqualTo(1)
        assertThat(multiplication).isEqualTo(2)
        assertThat(division).isEqualTo(2)
    }

    @Test
    fun find_symbol() {
        val direction = Direction

        val plusSymbol = direction.isPlus("+")
        val minusSymbol = direction.isMinus("-")
        val multiplicationSymbol = direction.isMultiplication("*")
        val divisionSymbol = direction.isDivision("/")

        assertThat(plusSymbol).isTrue()
        assertThat(minusSymbol).isTrue()
        assertThat(multiplicationSymbol).isTrue()
        assertThat(divisionSymbol).isTrue()
    }

    @Test
    fun division_has_zero() {
        assertThatThrownBy {
            val direction = Direction
            direction.division(2, 0)
        }.isInstanceOf(ArithmeticException::class.java).hasMessageContaining("0의값으로 나눌순 없습니다")
    }

    @Test
    fun not_symbol() {
        val symbol = "a"
        val numList = mutableListOf<Int>(1, 2)
        val direction = Direction

        assertThatThrownBy {
            direction.calculate(symbol, numList)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("사칙연산 기호가 아닙니다")
    }
}
