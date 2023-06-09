package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import java.lang.IllegalArgumentException

class CarTest {

    @Test
    fun `자동차는 현재 위치와 이름을 가진다`() {
        val actual = Car(position = 1, name = "pobi") { true }
        actual.position shouldBe 1
        actual.name shouldBe "pobi"
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val actual = Car(name = "pobi") { true }
        actual.position shouldBe 0
    }

    @Test
    fun `자동차의 이름이 5자를 초과할 경우 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> { Car(name = "12345") { true } }
        exception.message shouldBe "자동차의 이름을 5자를 초과할 수 없다"
    }

    @ParameterizedTest
    @EmptySource
    fun `자동차의 이름은 공백이 들어올 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { Car(name = input) { true } }
        exception.message shouldBe "자동차의 이름은 공백이 들어올 수 없다"
    }

    @Test
    fun `movable이 true면 전진한다`() {
        val car = Car(1, "pobi") { true }
        val actual = car.move()
        actual shouldBe 2
    }

    @Test
    fun `movable이 false면 움직이지 않는다`() {
        val car = Car(1, "pobi") { false }
        val actual = car.move()
        actual shouldBe 1
    }
}
