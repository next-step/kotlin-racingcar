package racingcar.etc

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAsNumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["123", "-1", "9987"])
    fun `숫자 문자열 변환 객체 생성 - 성공`(input: String) {
        val stringAsNumber = StringAsNumber(input)
        assertDoesNotThrow {
            stringAsNumber.toInt()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "r", "ㅁ"])
    fun `숫자 문자열 변환 객체 생성 - 실패`(input: String) {
        val stringAsNumber = StringAsNumber(input)
        assertThrows<IllegalArgumentException> {
            stringAsNumber.toInt()
        }
    }
}
