package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class NumberTest {

    @Test
    fun `숫자 제외 확인`() {
        val expression = "1일 2이 3삼"
        val result = "일 이 삼"
        Assertions.assertThat(extractNumber(expression)).isEqualTo(result)
    }
}
