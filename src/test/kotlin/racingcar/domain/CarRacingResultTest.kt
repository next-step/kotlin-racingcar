package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarRacingResultTest : BehaviorSpec({
    Given("자동차 경주 결과 초기값만 세팅하고") {
        val roundRange = 1..3
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val racingResult = CarRacingResult.createInitialResult(
            configuration = CarRacingResultConfiguration(roundRange),
            createInitialRoundResult = {
                CarRacingRoundResult.createInitialResult(RoundResultConfiguration(listOf(car1, car2)))
            }
        )
        When("라운드별 결과를 조회하면") {
            roundRange.forEach { roundNumber ->
                val roundResult = racingResult.getRoundResult(roundNumber)
                Then("라운드 결과가 조횐된다") {
                    roundResult.getCarPosition(0) shouldBe 0
                    roundResult.getCarPosition(1) shouldBe 0
                }
            }
        }
    }

    Given("자동차 경주 결과 초기값을 세팅하고") {
        val roundRange = 1..1
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val racingResult = CarRacingResult.createInitialResult(
            configuration = CarRacingResultConfiguration(roundRange),
            createInitialRoundResult = {
                CarRacingRoundResult.createInitialResult(RoundResultConfiguration(listOf(car1, car2)))
            }
        )
        And("자동차 경주 라운드 결과 값을 기록한 후") {
            val movedCar1 = Car(0, 1)
            val movedCar2 = Car(1, 2)
            val movedCars = listOf(movedCar1, movedCar2)
            racingResult.record(1, movedCars)
        }
        When("라운드별 결과를 조회하면") {
            val roundResult = racingResult.getRoundResult(1)
            Then("기록된 라운드 결과가 조횐된다") {
                roundResult.getCarPosition(0) shouldBe 1
                roundResult.getCarPosition(1) shouldBe 2
            }
        }
    }
})
