package calculator.operator

import calculator.operator.Operator.Plus
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class PlusOperatorTest {

    @Test
    fun `주어진 두 숫자에 대해서 더하기를 한다`() {
        val result = Plus.calculate(10, 5)
        assertThat(result).isEqualTo(15)
    }
}
