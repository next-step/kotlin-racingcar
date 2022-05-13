package racing.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("자동차 컬렉션 테스트")
class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    fun `자동차 이름 목록이 공백이면 예외 발생`(names: String) {
        // when, then
        val exception = assertThrows<IllegalArgumentException> { Cars.of(names) }
        assertEquals("이름 목록이 공백일 수 없습니다.", exception.message)
    }
}
