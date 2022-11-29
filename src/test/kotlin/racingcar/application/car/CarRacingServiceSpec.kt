package racingcar.application.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car
import racingcar.domain.car.CarFactory
import racingcar.domain.car.CarRacingResult

class CarRacingServiceSpec : BehaviorSpec({
    val carRacingService = CarRacingService()

    Given("자동차 경주 게임에") {
        val startRace = { cars: List<Car>, moves: Int ->
            carRacingService.startRace(cars, moves)
        }

        When("자동차 이름과 전진수를 입력하면") {
            val nameOfCars = setOf("pobi", "crong", "honux")
            val cars = CarFactory.create(nameOfCars)
            val moves = 5

            Then("경주 결과를 반환한다") {
                val result = startRace(cars, moves)

                result
                    .shouldHaveSize(moves)
                    .shouldForAll {
                        it.keys shouldHaveSize nameOfCars.size
                        it.keys.toList() shouldContainAll nameOfCars
                    }

                result.first().values.shouldForAll {
                    it.shouldBeGreaterThanOrEqual(0)
                }

                result.last().values.shouldForAll {
                    it.shouldBeLessThanOrEqual(moves)
                }
            }
        }
    }

    Given("자동차 경주에서") {
        val findWinners = { finalResult: CarRacingResult ->
            carRacingService.findWinners(finalResult)
        }
        When("가장 먼 거리를 이동한 자동차가 하나라면") {
            val finalResultOfCarRacing = mapOf(
                "pobi" to 3,
                "crong" to 4,
                "honux" to 3
            )

            Then("우승자는 한 명이다") {
                val winners = findWinners(finalResultOfCarRacing)

                winners
                    .shouldHaveSize(1)
                    .first().shouldBe("crong")
            }
        }
        When("가장 먼 거리를 이동한 자동차가 여러 개라면") {
            val finalResultOfCarRacing = mapOf(
                "pobi" to 3,
                "crong" to 4,
                "honux" to 4
            )

            Then("우승자는 여러 명이다") {
                val winners = findWinners(finalResultOfCarRacing)

                winners
                    .shouldHaveSize(2)
                    .intersect(setOf("crong", "honux"))
            }
        }
    }
})
