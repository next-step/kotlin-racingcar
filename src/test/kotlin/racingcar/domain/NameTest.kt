package racingcar.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {

    @ParameterizedTest(name = "이름 {0}일 경우")
    @ValueSource(strings = ["a", "aa", "aa", "aaaa", "jason"])
    fun `생성 정상 범위 이름의 길이가 1 ~ 5`(value: String) {
        assertDoesNotThrow { Name(value) }
    }

    @ParameterizedTest(name = "이름 {0}일 경우")
    @ValueSource(strings = ["", "ㅁㅁㅁㅁㅁㅁ"])
    fun `생성 정상 범위 이름의 길이가 0 또는 6`(value: String) {
        assertThrows<IllegalArgumentException> { Name(value) }
    }
}
