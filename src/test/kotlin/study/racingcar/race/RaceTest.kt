package study.racingcar.race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import study.racingcar.car.DefaultCarFactory
import study.racingcar.car.MoveGenerator

class RaceTest : BehaviorSpec({

    val alwaysMoveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = true
    }
    val neverMoveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = false
    }

    Given("alwaysMoveGenerator 가 주입되었을 때") {
        val carFactory = DefaultCarFactory()
        val carNames = listOf("car1", "car2", "car3")
        val cars = carFactory.createCars(carNames, alwaysMoveGenerator)

        When("경주를 시작하면") {
            val race = Race(cars, 2)
            val raceSummary = race.startRace()
            val results = raceSummary.raceResults

            Then("모든 자동차는 매 시도마다 위치가 증가한다.") {
                val expectedResults = listOf(
                    RaceResult(
                        listOf(
                            CarState("car1", 1),
                            CarState("car2", 1),
                            CarState("car3", 1)
                        )
                    ),
                    RaceResult(
                        listOf(
                            CarState("car1", 2),
                            CarState("car2", 2),
                            CarState("car3", 2)
                        )
                    )
                )
                results shouldBe expectedResults
            }
        }
    }

    Given("neverMoveGenerator 가 주입되었을 때") {
        val carFactory = DefaultCarFactory()
        val carNames = listOf("car1", "car2", "car3")
        val cars = carFactory.createCars(carNames, neverMoveGenerator)

        When("경주를 시작하면") {
            val race = Race(cars, 2)
            val raceSummary = race.startRace()
            val results = raceSummary.raceResults

            Then("모든 자동차의 위치가 변하지 않는다.") {
                val expectedResults = listOf(
                    RaceResult(
                        listOf(
                            CarState("car1", 0),
                            CarState("car2", 0),
                            CarState("car3", 0)
                        )
                    ),
                    RaceResult(
                        listOf(
                            CarState("car1", 0),
                            CarState("car2", 0),
                            CarState("car3", 0)
                        )
                    )
                )
                results shouldBe expectedResults
            }
        }
    }
})
