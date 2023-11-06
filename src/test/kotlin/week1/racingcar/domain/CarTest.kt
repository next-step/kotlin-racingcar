package week1.racingcar.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import week1.racingcar.domain.Car.Companion.MIN_NUM_TO_GO
import week1.racingcar.domain.Car.Companion.RANDOM_NUM_RANGE

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
        (0 until RANDOM_NUM_RANGE).forEach {
            val car = Car("K5")
            car.moveOrNotByNum(it)
            val expectedMileage = if (it < MIN_NUM_TO_GO) 0 else 1
            assertThat(car.currentMileage()).isEqualTo(expectedMileage)
        }
    }

    @Test
    fun `주행거리 비교`() {
        val car = Car("EV6")
        car.isSameMileage(0)
    }
}
