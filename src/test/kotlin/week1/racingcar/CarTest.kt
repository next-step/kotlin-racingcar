package week1.racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `생성자 확인`() {
        val car = Car("Thomas")
        car.name shouldBe "Thomas"
    }

    @Test
    fun `주행거리 체크`() {
        val car = Car("Thomas")
        car.mileage shouldBe 0

        car.go()
        car.mileage shouldBe 1
    }
}
