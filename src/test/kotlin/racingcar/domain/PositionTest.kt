package racingcar.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    @DisplayName("위치를 생성한다")
    fun create() {
        // given
        val position = Position()

        // when
        val actual = position.position

        // then
        assert(actual == 0)
    }

    @Test
    @DisplayName("위치를 1만큼 전진시킨다")
    fun forward() {
        // given
        val position = Position()

        // when
        position.forward()
        val actual = position.position

        // then
        assert(actual == 1)
    }

    @Test
    @DisplayName("위치를 비교한다")
    fun equal() {
        // given
        val position1 = Position(5)
        val position2 = Position(5)

        // when
        val actual = position1.equal(position2)

        // then
        assert(actual)
    }
}
