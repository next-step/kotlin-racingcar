package racingCar2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가진다`() {
        val car = Car("김태훈", 1)
        car.name shouldBe "김태훈"
        car.position shouldBe 1
    }
}
