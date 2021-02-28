package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MultiplyOperatorTest {
    @ParameterizedTest
    @CsvSource("0,0,0", "1,2,2", "-1,-3,3", "4,-6,-24", "-5,8,-40")
    fun `곱하기`(a: Int, b: Int, result: Int) {
        assertThat(MultiplyOperator.operate(a, b)).isEqualTo(result)
    }
}
