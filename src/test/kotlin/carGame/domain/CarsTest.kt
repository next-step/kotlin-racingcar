package carGame.domain

import carGame.test.FakeGenerator
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarsTest : BehaviorSpec({
    given("[moveBy 테스트] 자동차의 초기 위치가 0일 때") {
        val cars = FakeGenerator.genearteCars(size = 3, position = 0)

        `when`("movable이 true인 경우") {
            val movable: () -> Boolean = { true }

            then("전진한다.") {
                val result = cars.moveBy(movable)
                result.cars.map { it.position } shouldContainExactly listOf(1, 1, 1)
            }
        }

        `when`("movable이 false인 경우") {
            val movable: () -> Boolean = { false }

            then("멈춘다.") {
                val result = cars.moveBy(movable)
                result.cars.map { it.position } shouldContainExactly listOf(0, 0, 0)
            }
        }
    }
})
