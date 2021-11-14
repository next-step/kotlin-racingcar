package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoveDistanceTest {

    @Test
    fun `차량 이동거리 테스트`() {
        val actual = MoveDistance().apply { move() }
        assertThat(actual.distance).isEqualTo(1)
    }

    @Test
    fun `차량 위치 확인`() {
        val moveDistance = 5
        val actual = MoveDistance(moveDistance)
        assertThat(actual.isSameCarPosition(moveDistance)).isTrue
    }
}
