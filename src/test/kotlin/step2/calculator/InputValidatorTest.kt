package step2.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class InputValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" "])
    fun `예외 발생 - input값이 Null or Empty or Blank`(input: String?) {
        val exception = assertThrows<IllegalArgumentException> { InputValidator.validate(input) }
        assertEquals("입력된 값이 Null 이거나 공백입니다.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2 + 3 % 4 / 2",
            "2 ! 3 % 4 / 9",
            "1 = 1"
        ]
    )
    fun `예외 발생 - input값 내 산술식 아닌값 존재`(input: String?) {
        val exception = assertThrows<IllegalArgumentException> { InputValidator.validate(input) }
        assertEquals("입력된 값에 사칙 연산 기호가 아닌 값이 존재합니다.", exception.message)
    }
}
