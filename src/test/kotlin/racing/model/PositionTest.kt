package racing.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 위치 테스트")
class PositionTest {

    @Test
    fun `자동차 위치가 0 미만이면 0으로 생성`() {
        // given, when
        val position = Position(-1)

        // then
        assertEquals(position.position, 0)
    }

    @Test
    fun `자동차 위치가 0 이상이면 정상 생성`() {
        // given, when, then
        Position(0)
    }

    @Test
    fun `자동차 위치가 0인 경우 앞으로 한 칸 이동하면 자동차 위치가 1로 증가`() {
        // given
        val position = Position(0)

        // when
        position.plusOne()

        // then
        assertEquals(position.position, 1)
    }
}
