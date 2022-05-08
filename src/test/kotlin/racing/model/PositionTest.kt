package racing.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 위치 테스트")
class PositionTest {

    @Test
    fun `자동차 위치가 0 미만이면 예외 발생`() {
        // given, when, then
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Position(-1)
        }
        assertEquals("위치값은 최소 0 이상이어야 합니다. (position: -1)", exception.message)
    }

    @Test
    fun `자동차 위치가 0 이상이면 정상 생성`() {
        // given, when, then
        Position(0)
    }

    @Test
    fun `plusOne()을 실행하면 자동차 위치가 1만큼 증가`() {
        // given
        val position = Position(0)

        // when
        position.plusOne()

        // then
        assertEquals(position.position, 1)
    }
}
