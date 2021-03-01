package number

import number.Numbers.MAX_RANDOM_NUMBER
import number.Numbers.MIN_RANDOM_NUMBER
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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

    @Test
    fun `Racing 에 사용할 0과 10사이의 임의의 숫자를 만든다`() {
        val number = Numbers.randomToRacing()

        assertAll(
            { assertThat(number).isGreaterThan(MIN_RANDOM_NUMBER) },
            { assertThat(number).isLessThan(MAX_RANDOM_NUMBER) }
        )
    }
}
