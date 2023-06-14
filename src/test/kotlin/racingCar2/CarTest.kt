package racingCar2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가진다`() {
        val car = Car("김태훈", 1)
        car.name shouldBe "김태훈"
        car.position shouldBe 1
    }

    @Test
    fun `자동차의 이름은 5자를 초과할 수 없다`() {
        shouldThrow<IllegalStateException> {
            Car("잘생긴 김태훈", 1)
        }
    }
}
