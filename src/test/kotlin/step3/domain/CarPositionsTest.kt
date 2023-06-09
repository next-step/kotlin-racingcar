package step3.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarPositionsTest : BehaviorSpec({
    given("[moveBy 테스트] 자동차의 초기 위치가 0일 때") {
        val positions = CarPositions.of(size = 3, initialPosition = 0)

        `when`("movable이 true인 경우") {
            val movable: () -> Boolean = { true }

            then("위치가 한칸씩 이동된다.") {
                val result = positions.moveBy(movable)
                result.getPositions() shouldContainExactly listOf(1, 1, 1)

            }
        }

        `when`("movable이 false인 경우") {
            val movable: () -> Boolean = { false }

            then("위치는 변하지 않는다") {
                val result = positions.moveBy(movable)
                result.getPositions() shouldContainExactly listOf(0, 0, 0)
            }
        }
    }
})
