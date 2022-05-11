package racing.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("숫자 테스트")
class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    fun `숫자가 0에서 9 사이가 아니면 예외가 발생`(number: Int) {
        // when, then
        val exception = assertThrows<IllegalArgumentException> { Number(number) }
        assertEquals("숫자는 0 이상 9 이하이어야 합니다. (number: $number)", exception.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 9])
    fun `숫자가 0에서 9 사이면 정상 생성`(number: Int) {
        // when, then
        Number(number)
    }
}
