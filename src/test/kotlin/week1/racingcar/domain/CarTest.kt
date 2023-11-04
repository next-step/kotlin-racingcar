package week1.racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `생성자 확인`() {
        val car1 = Car("James")
        car1.name shouldBe "James"

        assertThrows(IllegalArgumentException::class.java) {
            Car("Thomas")
        }
    }

    @Test
    fun `한 턴 진행`() {
        val car1 = Car("K5")
        repeat(DEFAULT_TEST_TIMES) {
            car1.moveOrNot()
        }
        assert(car1.mileage <= DEFAULT_TEST_TIMES)

        val car2 = Car("G80")
        repeat(MAX_TEST_TIMES) {
            car2.moveOrNot()
        }
        assert(car1.mileage <= MAX_TEST_TIMES)
    }

    @Test
    fun `주행거리 비교`() {
        val car = Car("EV6")
        car.isSameMileage(0)
    }

    companion object {
        private const val DEFAULT_TEST_TIMES = 1
        private const val MAX_TEST_TIMES = 5
    }
}
