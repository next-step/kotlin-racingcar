package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.strategy.FakeAlwaysMoveStrategy

internal class ParticipatedCarsTest : BehaviorSpec({
    Given("자동차는") {
        val participatedCars = ParticipatedCars(FakeAlwaysMoveStrategy())
        val car = Car("a", 0)
        When("이동 횟수만큼") {
            val finalCarsInfo = participatedCars.turn(
                1, 3,
                listOf(car)
            )

            Then("이동한다") {
                finalCarsInfo.first().currentPosition shouldBe 3
            }
        }
    }
})
