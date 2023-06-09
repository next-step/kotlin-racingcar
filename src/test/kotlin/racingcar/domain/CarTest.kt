package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 현재 위치를 가진다`() {
        val actual = Car(1) { true }
        actual.position shouldBe 1
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val actual = Car { true }
        actual.position shouldBe 0
    }

    @Test
    fun `movable이 true면 전진한다`() {
        val car = Car(1) { true }
        val actual = car.move()
        actual shouldBe 2
    }

    @Test
    fun `movable이 false면 움직이지 않는다`() {
        val car = Car(1) { false }
        val actual = car.move()
        actual shouldBe 1
    }
}
