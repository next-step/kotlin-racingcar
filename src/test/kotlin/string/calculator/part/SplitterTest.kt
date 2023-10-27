package string.calculator.part

import org.junit.jupiter.api.Test
import string.calculator.domain.Operator

internal class SplitterTest {

    @Test
    fun `공백을 기준으로 분해가 되는지 확인 한다`() {
        val input = "1 + 2 - 1 * 4 / 5"
        val result = Splitter().split(input)

        assert(result.numbers == mutableListOf(1L, 2L, 1L, 4L, 5L))
        assert(result.operators == mutableListOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE))
    }
}
