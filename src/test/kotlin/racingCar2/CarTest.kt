package racingCar2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가진다`() {
        val car = Car("김태훈")
        car.name shouldBe "김태훈"
        car.position shouldBe 0
    }

    @Test
    fun `자동차의 처음 위치는 0이다`() {
        val car = Car("김태훈")
        car.position shouldBe 0
    }

    @ParameterizedTest
    @CsvSource(
        "훈태김태훈",
        "잘생긴김태훈"
    )
    fun `자동차의 이름은 5자를 초과할 수 없다`(name: String) {
        shouldThrow<IllegalStateException> {
            Car(name)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "다리우스",
        "드레이븐"
    )
    fun `자동차의 이름은 4자 까지 가능하다`(name: String) {
        Car(name)
    }

    @ParameterizedTest
    @CsvSource(
        "4, 1",
        "3, 0"
    )
    fun `랜덤 숫자가 4 이상이면 자동차는 이동할 수 있다`(randomNumber: Int, expected: Int) {
        val car = Car("훈")
        car.move(randomNumber)
        car.position shouldBe expected
    }
}
