package calculator.operator

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test

internal class MinusOperatorTest {

    @Test
    fun `주어진 두 숫자에 대해서 빼기를 한다`() {
        val result = MinusOperator.operate(10, 8)
        AssertionsForClassTypes.assertThat(result).isEqualTo(2)
    }
}
