package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.fixture.ALWAYS_MOVING_STRATEGY
import racingcar.fixture.NEVER_MOVING_STRATEGY

class CarTest {

    @Test
    fun `자동차의 기본 위치는 0이다`() {
        val car = Car(ALWAYS_MOVING_STRATEGY, "hello")

        car.position shouldBe 0
    }

    @Test
    fun `성공하는 전략을 주입시 자동차가 전진한다`() {
        val car = Car(ALWAYS_MOVING_STRATEGY, "hello")

        car.move()

        car.position shouldBe 1
    }

    @Test
    fun `실패하는 전략을 주입시 자동차가 멈춘다`() {
        val car = Car(NEVER_MOVING_STRATEGY, "hello")

        car.move()

        car.position shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "asdfgh"])
    fun `자동차 이름이 1자 미만, 5자 초과이면 예외가 발생한다`(name: String) {
        shouldThrow<IllegalArgumentException> { Car.of(ALWAYS_MOVING_STRATEGY, name) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["hello", "w"])
    fun `자동차 이름이 1자 이상, 5자 이하이면 예외가 발생하지 않는다`(name: String) {
        shouldNotThrowAny { Car.of(ALWAYS_MOVING_STRATEGY, name) }
    }

    @Test
    fun `현재 자동차 정보를 요청하면 이름과 포지션을 반환한다`() {
        val car = Car.of(ALWAYS_MOVING_STRATEGY, "hello")

        car.getCurrentInfo() shouldBe CarInfo("hello", 0)
    }
}
