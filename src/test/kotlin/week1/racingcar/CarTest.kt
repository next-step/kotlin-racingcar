package week1.racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import week1.racingcar.domain.Car

class CarTest {
    @Test
    fun `생성자 확인`() {
        val car = Car("Thomas")
        car.name shouldBe "Thomas"
    }
}
