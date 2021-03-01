package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SubtractOperatorTest {
    @ParameterizedTest
    @CsvSource("0,0,0", "1,2,-1", "-1,-3,2", "4,-6,10", "-5,8,-13")
    fun `빼기`(a: Int, b: Int, result: Int) {
        assertThat(
            SubtractOperator.operate(Scalar(a), Scalar(b))
        ).isEqualTo(Scalar(result))
    }
}
