package racing_car.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    context("자동차의 초기 위치는 0이다.") {
        val car = Car()
        car.position shouldBe 0
    }

    context("항상 이동하는 자동차는 항상 앞으로 이동한다.") {
        withData(
            nameFn = { "numberOfMove : $it" },
            1, 5, 12,
        ) { numberOfMove ->

            val car = Car(moveStrategy = alwaysMoveStrategy)
            repeat(numberOfMove) {
                car.move()
            }
            car.position shouldBe numberOfMove
        }
    }

    context("절대 이동하는 않는 자동차는 항상 제자리다.") {
        withData(
            nameFn = { "numberOfMove : $it" },
            1, 5, 12,
        ) { numberOfMove ->

            val car = Car(moveStrategy = neverMoveStrategy)
            repeat(numberOfMove) {
                car.move()
            }

            car.position shouldBe 0
        }
    }
}) {
    companion object {
        val alwaysMoveStrategy = MoveStrategy { true }

        val neverMoveStrategy = MoveStrategy { false }
    }
}
