package racing.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("자동차 이름 테스트")
class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    fun `자동차 이름이 공백이면 예외 발생`(name: String) {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> { Name(name) }
        Assertions.assertEquals("이름이 공백일 수 없습니다.", exception.message)
    }
}