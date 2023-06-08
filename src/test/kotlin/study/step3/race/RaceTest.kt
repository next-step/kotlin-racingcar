package study.step3.race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import study.step3.car.DefaultCarFactory

class RaceTest : BehaviorSpec({

    val alwaysMoveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = true
    }
    val neverMoveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = false
    }

    Given("alwaysMoveGenerator 가 주입되었을 때") {
        val carFactory = DefaultCarFactory()
        When("경주를 시작하면") {
            val race = Race(3, 2, alwaysMoveGenerator, carFactory)
            val results = race.startRace()
            Then("모든 자동차는 매 시도마다 위치가 증가한다.") {
                results shouldBe listOf(listOf("-", "-", "-"), listOf("--", "--", "--"))
            }
        }
    }

    Given("neverMoveGenerator 가 주입되었을 때") {
        val carFactory = DefaultCarFactory()
        When("경주를 시작하면") {
            val race = Race(3, 2, neverMoveGenerator, carFactory)
            val results = race.startRace()
            Then("모든 자동차의 위치가 변하지 않는다.") {
                results shouldBe listOf(listOf("", "", ""), listOf("", "", ""))
            }
        }
    }
})
