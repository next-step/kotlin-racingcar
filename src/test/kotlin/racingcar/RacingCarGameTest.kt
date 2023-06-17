package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class RacingCarGameTest : BehaviorSpec({
    Given("자동차 이름은 쉼표(,)를 기준으로 구분한다.") {
        When("자동차 이름이 n개와 쉼표(,)로 구성된 문자열 입력이 들어온다.") {
            listOf(
                "pobi,crong,honux",
                "pobi,crong"
            ).forAll {
                Then("각각의 이름을 가진 자동차 n개가 생성된다.") {
                    val racingCars = RacingCars(it)
                    val inputs = it.split(",")

                    racingCars.cars.size shouldBe inputs.size
                    (racingCars.cars.indices).forEach {
                        racingCars.cars[it].name shouldBe inputs[it]
                    }
                }
            }
        }
    }

    Given("Position의 값이 가장 큰 자동차가 우승자이다.") {
        When("위치가 1인 pavlo 와 위치가 2인 wade 자동차가 있다") {
            val racingCars = RacingCars()
            val pavloCar = RacingCar("pavlo", 1)
            val wadeCar = RacingCar("wade", 2)
            racingCars.addCar(pavloCar)
            racingCars.addCar(wadeCar)
            Then("우승자는 wade이다.") {
                racingCars.getWinners() shouldContain wadeCar
            }
        }
        When("위치 값이 가장 크면서 같은 두 자동차가 있다") {
            val racingCars = RacingCars()
            val pavloCar = RacingCar("pavlo", 2)
            val wadeCar = RacingCar("wade", 2)
            val loserCar = RacingCar("loser", 1)
            racingCars.addCar(pavloCar)
            racingCars.addCar(wadeCar)
            racingCars.addCar(loserCar)
            Then("우승자는 pavlo,wade 이다") {
                racingCars.getWinners() shouldContain pavloCar
                racingCars.getWinners() shouldContain wadeCar
            }
        }
    }
})
