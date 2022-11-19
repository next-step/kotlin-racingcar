package racingcar.application.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import racingcar.domain.car.Car
import racingcar.domain.car.CarFactory

class CarRacingSpec : BehaviorSpec({
    Given("자동차 경주 게임에") {
        val carRacingGame = { cars: List<Car>, moves: Int ->
            CarRacing.startRace(cars, moves)
        }

        When("자동차 이름과 전진수를 입력하면") {
            val nameOfCars = listOf("pobi", "crong", "honux")
            val cars = CarFactory.create(nameOfCars)
            val moves = 5

            Then("경주 결과를 반환한다") {
                val result = carRacingGame(cars, moves)

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
})
