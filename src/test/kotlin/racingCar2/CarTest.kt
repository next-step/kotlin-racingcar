package racingCar2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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

    @ParameterizedTest
    @CsvSource(
        "10, 2",
        "3, 1"
    )
    fun `랜덤 숫자가 4 이상이면 자동차는 이동할 수 있다`(randomNumber: Int, expected: Int) {
        val car = Car("훈", 1)
        car.move(randomNumber)
        car.position shouldBe expected
    }
}
