package racingcar.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "crong", "honux"])
    fun `자동차 이름 생성 - 성공`(input: String) {
        assertDoesNotThrow {
            CarName(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["raemerrr", "123456"])
    @EmptySource
    fun `자동차 이름 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            CarName(input)
        }
    }
}