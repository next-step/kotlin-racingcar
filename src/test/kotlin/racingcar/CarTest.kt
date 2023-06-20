package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.fixture.ALWAYS_MOVING_STRATEGY
import racingcar.fixture.NEVER_MOVING_STRATEGY

class CarTest {

    @Test
    fun `자동차의 기본 위치는 0이다`() {
        val car = Car()

        car.position shouldBe 0
    }

    @Test
    fun `성공하는 전략을 주입시 자동차가 전진한다`() {
        val car = Car()

        car.move(ALWAYS_MOVING_STRATEGY)

        car.position shouldBe 1
    }

    @Test
    fun `실패하는 전략을 주입시 자동차가 멈춘다`() {
        val car = Car()

        car.move(NEVER_MOVING_STRATEGY)

        car.position shouldBe 0
    }
}
