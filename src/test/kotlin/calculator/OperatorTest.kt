package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `기호 연산자 제외 추출 확인`() {
        val expression = "%9 $+ 8 - 7 * 6 / 5"
        val result = "% $       "
        Assertions.assertThat(extractOperator(expression)).isEqualTo(result)
    }
}
