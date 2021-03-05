package racing.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RacingCarNameTest {

    @DisplayName("자동차의 이름에 공백이 포함되지 않은 경우 객체 생성")
    @Test
    fun validateBlank() {
        val actual = RacingCarName("name")
        assertThat(actual).isNotNull
    }

    @DisplayName("자동차의 이름에 공백이 포함된 경우 예외 발생")
    @Test
    fun validateBlank_exception() {
        assertThatThrownBy { RacingCarName("n a m e") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("자동차 이름의 길이가 8글자 이하인 경우 객체 생성")
    @Test
    fun validateLength() {
        val actual = RacingCarName("12345678")
        assertThat(actual).isNotNull
    }

    @DisplayName("자동차 이름의 길이가 9글자 이상인 경우 예외 발생")
    @Test
    fun validateLength_exception() {
        assertThatThrownBy { RacingCarName("123456789") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}