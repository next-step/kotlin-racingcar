package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.moving.MoveStrategy

class CarTest : AnnotationSpec() {
    private val moveStrategy = object : MoveStrategy {
        override fun isMovable(): Boolean {
            return true
        }
    }

    private val notMoveStrategy = object : MoveStrategy {
        override fun isMovable(): Boolean {
            return false
        }
    }

    @Test
    fun `자동차 생성시 초기 위치는 0이다`() {
        // given
        // when
        val car = Car()
        // then
        car.position shouldBe 0
    }

    @Test
    fun `자동차는 한칸 이동한다`() {
        // given
        val car = Car(10)
        // when
        val movedCar = car.move(moveStrategy)
        // then
        movedCar.position shouldBe 11
    }

    @Test
    fun `자동차는 이동하지 않는다`() {
        val car = Car(10)
        // when
        val movedCar = car.move(notMoveStrategy)
        // then
        movedCar.position shouldBe 10
    }
}
