package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream

class InputViewTest {

    @ParameterizedTest
    @DisplayName("자동차 이름의 입력이 pobi,crong,honux 일 경우 3대의 자동차 등록이 됨")
    @ValueSource(strings = ["pobi,crong,honux\n5"])
    fun `3 if when participant input value is pobi,crong,honux`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        val register = InputView.register()
        assertThat(register.participant.size).isEqualTo(3)
    }

    @ParameterizedTest
    @DisplayName("자동차 이름의 입력이 공백일 경우 IllegalArgumentException 오류")
    @ValueSource(strings = [" \n5"])
    fun `Error when participant input value is blank`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        assertThrows<IllegalArgumentException> {
            InputView.register()
        }
    }

    @ParameterizedTest
    @DisplayName("자동차 이름의 입력이 5자를 초과할 경우 IllegalArgumentException 오류")
    @ValueSource(strings = ["asdfghjkll\n5"])
    fun `Error when participant input value is 5 length`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        assertThrows<IllegalArgumentException> {
            InputView.register()
        }
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수의 입력 값이 0일 경우 IllegalArgumentException 오류")
    @ValueSource(strings = ["pobi,crong,honux\n0"])
    fun `Error when number input value is 0`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        assertThrows<IllegalArgumentException> {
            InputView.register()
        }
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 앞/뒤로 공백이 들어간 경우 공백이 제거됨")
    @ValueSource(strings = [" po ,crong,honux\n5"])
    fun `Remove spaces if front_back spaces are included in the car name`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)

        val register = InputView.register()
        assertThat(register.participant.contains(" po ")).isFalse
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 중간에 공백 포함되어도 자동차 등록이 됨")
    @ValueSource(strings = ["Hi kt\n5"])
    fun `Register a car with spaces in the middle of the car name`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)

        val register = InputView.register()
        assertThat(register.participant.contains("Hi kt")).isTrue
    }

    object InputStream {
        fun generate(input: String) = ByteArrayInputStream(input.toByteArray())
    }
}
