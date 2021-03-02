package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class AddOperatorTest {
    @ParameterizedTest
    @CsvSource("0,0,0", "1,2,3", "-1,-3,-4", "4,-6,-2", "-5,8,3")
    fun `더하기`(a: Int, b: Int, result: Int) {
        assertThat(
            AddOperator.operate(Scalar(a), Scalar(b))
        ).isEqualTo(Scalar(result))
    }
}
