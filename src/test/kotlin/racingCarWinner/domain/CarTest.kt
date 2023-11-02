package racingCarWinner.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `randomNumber가 4 이상일 때 차는 1칸 앞으로 전진한다`() {
        // given
        val randomNumber = 5

        // when
        val car = Car()
        TODO("차에 전진하는 기능을 추가한다.")

        // then
        assertEquals(1, car.location)
    }

    @Test
    fun `randomNumber가 4 미만일 때 차는 그대로 멈춰있다`() {
        // given
        val randomNumber = 1

        // when
        val car = Car()
        TODO("차에 전진하는 기능을 추가한다.")

        // then
        assertEquals(0, car.location)
    }
}