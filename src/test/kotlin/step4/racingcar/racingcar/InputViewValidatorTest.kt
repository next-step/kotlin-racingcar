package step4.racingcar.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["abc,abcd,abcdefg"])
    fun `예외 발생 선수이름 5자 이상`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { InputViewValidator.racers(input.split(",")) }
        assertEquals("입력된 선수의 이름이 5자 이상인 선수가 있습니다.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,ab,abc,abcd,abcde"])
    fun `선수이름 5자 이내 검증 성공`(input: String) {
        InputViewValidator.racers(input.split(","))
    }
}
