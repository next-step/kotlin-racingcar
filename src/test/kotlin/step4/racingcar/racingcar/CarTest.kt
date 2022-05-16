package step4.racingcar.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 생성 테스트`() {
        val randCarCount = (0..9).random()
        val cars = List(randCarCount) { Car(it.toString(), SuccessEngine()) }

        assertEquals(cars.count(), randCarCount)
    }

    @Test
    fun `자동차 이동 실패 테스트`() {
        val randMoveCount = (0..9).random()
        val car = Car("실패", FailEngine())
        repeat(randMoveCount) {
            car.move()
        }

        assertEquals(car.movements.count { !it }, randMoveCount)
    }

    @Test
    fun `자동차 이동 성공 테스트`() {
        val randMoveCount = (0..9).random()
        val car = Car("성공", SuccessEngine())
        repeat(randMoveCount) {
            car.move()
        }

        assertEquals(car.movements.count { it }, randMoveCount)
    }
}
