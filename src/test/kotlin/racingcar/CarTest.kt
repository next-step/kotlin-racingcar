package racingcar

import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.movingstrategy.MovingStrategy

class CarTest {

    @Test
    fun `자동차의 기본 위치는 0이다`() {
        val car = Car()

        car.position shouldBe 0
    }

    @Test
    fun `전략을 주입하지 않으면 기본 전략이 사용된다`() {
        val car = Car()

        car.move()

        car.position.shouldBeIn(0, 1)
    }

    @Test
    fun `성공하는 전략을 주입시 자동차가 전진한다`() {
        val car = Car()

        car.move(alwaysMovingStrategy())

        car.position shouldBe 1
    }

    @Test
    fun `실패하는 전략을 주입시 자동차가 멈춘다`() {
        val car = Car()

        car.move(neverMovingStrategy())

        car.position shouldBe 0
    }

    private fun neverMovingStrategy() = object : MovingStrategy {
        override fun isMovable(): Boolean {
            return false
        }
    }

    private fun alwaysMovingStrategy() = object : MovingStrategy {
        override fun isMovable(): Boolean {
            return true
        }
    }
}
