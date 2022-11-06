package calculator.operator

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test

internal class MultiplyOperatorTest {

    @Test
    fun `주어진 두 숫자에 대해서 곱하기를 한다`() {
        val result = MultiplyOperator.operate(10, 8)
        AssertionsForClassTypes.assertThat(result).isEqualTo(80)
    }
}
