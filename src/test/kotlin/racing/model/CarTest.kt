package racing.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    fun `위치 값 없이 자동차를 생성하면 위치 값은 0`() {
        // given, when
        val car = Car.from("aiden")

        // then
        assertEquals(car.position(), 0)
    }

    @Test
    fun `앞으로 전진하는 조건이 참이면 앞으로 1칸 전진`() {
        // given
        val car = Car.from("aiden")

        // when
        car.moveForward { true }

        // then
        assertEquals(car.position(), 1)
    }

    @Test
    fun `앞으로 전진하는 조건이 거짓이면 멈춤`() {
        // given
        val car = Car.from("aiden")

        // when
        car.moveForward { false }

        // then
        assertEquals(car.position(), 0)
    }
}
