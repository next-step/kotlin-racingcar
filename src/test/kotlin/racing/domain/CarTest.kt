package racing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차 생성 테스트(초기 위치는 0, 지정된 이름 확인)`() {
        // given
        val name = Name("name")

        // when
        val car = Car(name, forwardByOneMoveStrategy)

        // then
        assertEquals(name, car.name)
        assertEquals(0, car.position)
    }

    @Test
    fun `앞으로 1씩 이동하는 자동차 테스트`() {
        // given
        val car = Car(Name("name"), forwardByOneMoveStrategy)

        // when
        car.move()

        // then
        assertEquals(1, car.position)
    }

    @Test
    fun `절대 이동하지 않는 자동차 테스트`() {
        // given
        val car = Car(Name("name"), stopMoveStrategy)

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
