package carrace.logic.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see CarPosition
 */
class CarPositionTest : FunSpec({

    context("CarPosition 단위 테스트") {
        val defaultPosition = 0
        val defaultCarPosition = CarPosition(defaultPosition)

        test("fun getValue(): 현재 위치를 반환한다.") {
            val position = shouldNotThrowAny {
                defaultCarPosition.position
            }

            position shouldBe defaultPosition
        }

        test("fun move(): 움직인 거리만큼 carPosition의 위치도 변경") {
            val movingDistance = 1
            val movedPosition = defaultCarPosition.move(movingDistance)

            movedPosition.position shouldBe defaultPosition + movingDistance
        }
    }
})
