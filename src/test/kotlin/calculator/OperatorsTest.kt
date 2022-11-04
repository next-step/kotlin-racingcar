package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperatorsTest{

    @Test
    fun `연산자를 추가해야 합니다`(){
        val operators = Operators()
        operators.add("+")
        assertThat(operators.getOperator()).isEqualTo(Operator.PLUS)
    }    
    @Test
    fun `계산 가능한지 여부를 반환해야 합니다`(){
        val operators = Operators()
        operators.add("+")
        assertThat(operators.isCalculable()).isTrue()
    }

    @Test
    fun `유효하지 않은 입력값인 경우, 예외를 터트려야 합니다`(){
        val operators = Operators()
        assertThatThrownBy { operators.add("1") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
            operators.add("*")
            operators.add("-")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
