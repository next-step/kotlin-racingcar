package domain.number

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `String을 입력받아서 Int 로 리턴한다`() {
        assertThat(Numbers.toInt("5")).isEqualTo(5)
    }

    @Test
    fun `숫자가 아닌 값을 입력받았을 때 예외처리한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            assertThat(Numbers.toInt("값")).isEqualTo(5)
        }.withMessageMatching("value는 숫자여야 합니다. value : 값")
    }
}
