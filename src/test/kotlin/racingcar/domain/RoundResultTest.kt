package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RoundResultTest : BehaviorSpec({
    Given("자동차 경주 라운드 결과 초기값만 세팅하고") {
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val roundResult = RoundResult.createInitialResult(
            RoundResultConfiguration(
                cars = listOf(car1, car2)
            )
        )
        When("자동차 경주 라운드 결과 값을 조회하면") {
            val car1Result = roundResult.getCarPosition(0)
            val car2Result = roundResult.getCarPosition(1)
            Then("세팅된 초기값이 조회된다") {
                car1Result shouldBe 0
                car2Result shouldBe 0
            }
        }
    }

    Given("자동차 경주 라운드 초기값을 세팅하고") {
        val initialCar1 = Car(0, 0)
        val initialCar2 = Car(1, 0)
        val initialCars = listOf(initialCar1, initialCar2)
        val roundResult = RoundResult.createInitialResult(
            RoundResultConfiguration(
                cars = initialCars
            )
        )
        And("자동차 경주 라운드 결과 값을 기록한 후") {
            val movedCar1 = Car(0, 1)
            val movedCar2 = Car(1, 2)
            val movedCars = listOf(movedCar1, movedCar2)

            roundResult.record(movedCars)
        }
        When("자동차 경주 라운드 결과 값을 자동차 별로 조회하면") {
            val car1Result = roundResult.getCarPosition(0)
            val car2Result = roundResult.getCarPosition(1)
            Then("기록된 라운드 결과가 조회된다") {
                car1Result shouldBe 1
                car2Result shouldBe 2
            }
        }
    }
})
