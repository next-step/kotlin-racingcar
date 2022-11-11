package racingcar.view

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream

class InputViewTest {

    @ParameterizedTest
    @DisplayName("자동차 등록의 입력 값이 0일 경우 IllegalArgumentException 오류")
    @ValueSource(strings = ["0\n5"])
    fun `Error when participant input value is 0`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        assertThrows<IllegalArgumentException> {
            InputView.register()
        }
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수의 입력 값이 0일 경우 IllegalArgumentException 오류")
    @ValueSource(strings = ["5\n0"])
    fun `Error when number input value is 0`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        assertThrows<IllegalArgumentException> {
            InputView.register()
        }
    }

    object InputStream {
        fun generate(input: String) = ByteArrayInputStream(input.toByteArray())
    }
}
