package racingcar.domain.car

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.moving.MoveStrategy

class CarTest : AnnotationSpec() {
    private val movingStrategy = object : MoveStrategy {
        override fun isMovable(): Boolean {
            return true
        }
    }

    private val notMovingStrategy = object : MoveStrategy {
        override fun isMovable(): Boolean {
            return false
        }
    }

    @Test
    fun `자동차 생성시 초기 위치는 0이다`() {
        // given
        // when
        val car = Car(movingStrategy)
        // then
        car.position.value shouldBe 0
    }

    @Test
    fun `자동차는 한칸 이동한다`() {
        // given
        val car = Car(movingStrategy)
        // when
        car.move()
        // then
        car.position.value shouldBe 1
    }

    @Test
    fun `자동차는 두칸 이동한다`() {
        // given
        val car = Car(movingStrategy)
        // when
        car.move()
        car.move()
        // then
        car.position.value shouldBe 2
    }

    @Test
    fun `자동차는 이동하지 않는다`() {
        val car = Car(notMovingStrategy)
        // when
        car.move()
        car.move()
        // then
        car.position.value shouldBe 0
    }
}
