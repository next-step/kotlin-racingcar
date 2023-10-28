package study.step3.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("이동은 shouldMove가 참일 때 위치를 증가시켜야 한다")
    fun `move should increment position when shouldMove is true`() {
        val car = Car()
        car.move(true)
        assertEquals(1, car.position)
    }

    @Test
    @DisplayName("이동은 shouldMove가 거짓일 때 위치를 증가시키지 않아야 한다")
    fun `move should not increment position when shouldMove is false`() {
        val car = Car()
        car.move(false)
        assertEquals(0, car.position)
    }

    @Test
    @DisplayName("위치를 표시하는 문자열은 위치만큼 -로 구성되어야 한다")
    fun `displayPosition should return correct string`() {
        val car = Car()
        car.move(true)
        assertEquals("-", car.displayPosition())
    }
}
