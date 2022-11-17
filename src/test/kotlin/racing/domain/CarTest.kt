package racing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        // given & when
        val car = Car(forwardByOneMoveStrategy)

        // then
        assertEquals(0, car.position)
    }

    @Test
    fun `앞으로 1씩 이동하는 자동차 테스트`() {
        // given
        val car = Car(forwardByOneMoveStrategy)

        // when
        car.move()

        // then
        assertEquals(1, car.position)
    }

    @Test
    fun `절대 이동하지 않는 자동차 테스트`() {
        // given
        val car = Car(stopMoveStrategy)

        // when
        car.move()

        // then
        assertEquals(0, car.position)
    }

    companion object {
        val forwardByOneMoveStrategy = MoveStrategy { 1 }

        val stopMoveStrategy = MoveStrategy { 0 }
    }
}
