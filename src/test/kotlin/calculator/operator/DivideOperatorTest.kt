package calculator.operator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class DivideOperatorTest {

    @Test
    fun `주어진 두 숫자에 대해서 나누기를 한다`() {
        val result = DivideOperator.operate(10, 5)
        assertThat(result).isEqualTo(2)
    }
}
