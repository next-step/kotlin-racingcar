package racing.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    fun `앞으로 전진하는 조건이 참이면 앞으로 1칸 전진`() {
        // given
        val car = Car()
        assertEquals(car.position(), 0)

        // when
        car.moveForward(object : MovingStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        })

        // then
        assertEquals(car.position(), 1)
    }
}
