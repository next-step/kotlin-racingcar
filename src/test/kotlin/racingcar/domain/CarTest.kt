package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    private val dummyCarName = "dummy"
    
    @Test
    fun `자동차의 초기 거리는 0이다`() {
        val dummyMoveStrategy = DummyMoveStrategy()
        val car = Car(name = dummyCarName, moveStrategy = dummyMoveStrategy)
        val expected = 0

        assertThat(car.currentDistance()).isEqualTo(expected)
    }

    @Test
    fun `자동차가 이동할 수 있는 경우 지정한 거리만큼 움직인다`() {
        // given
        val moveableMoveStrategy = MoveableMoveStrategy()
        val moveDepth = 1
        val car = Car(name = dummyCarName, moveStrategy = moveableMoveStrategy, moveDepth = moveDepth)

        // when
        car.moveIfMoveable()

        // then
        assertThat(car.currentDistance()).isEqualTo(moveDepth)
    }

    @Test
    fun `자동차가 이동할 수 없는 경우 움직이지 않는다`() {
        // given
        val unmoveableMoveStrategy = UnmoveableMoveStrategy()
        val car = Car(name = dummyCarName, moveStrategy = unmoveableMoveStrategy)
        val expected = 0

        // when
        car.moveIfMoveable()

        // then
        assertThat(car.currentDistance()).isEqualTo(expected)
    }
}
