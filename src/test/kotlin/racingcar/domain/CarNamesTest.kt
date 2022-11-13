package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNamesTest {

    @Test
    fun `자동차 이름 컬렉션 생성 - 성공`() {
        assertDoesNotThrow {
            CarNames("pobi,crong,honux")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["raemerrr", ",crong,honux", "pobi,,honux", "pobi,crong,"])
    @EmptySource
    fun `자동차 이름 컬렉션 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            CarNames(input)
        }
    }
}
