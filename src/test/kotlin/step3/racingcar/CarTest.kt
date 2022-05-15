package step3.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 이동 실패 테스트`() {
        val randMoveCount = (0..9).random()
        val car = Car(FailEngine())
        repeat(randMoveCount) {
            car.move()
        }

        assertEquals(car.movements.count { !it }, randMoveCount)
    }

    @Test
    fun `자동차 이동 성공 테스트`() {
        val randMoveCount = (0..9).random()
        val car = Car(SuccessEngine())
        repeat(randMoveCount) {
            car.move()
        }

        assertEquals(car.movements.count { it }, randMoveCount)
    }
}
