package racingcar.domain.result

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.configuration.CarRacingResultConfiguration
import racingcar.domain.car.Car

class CarRacingResultTest : BehaviorSpec({
    Given("자동차 경주 결과 초기값만 세팅하고") {
        val roundRange = 1..3
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val racingResult = CarRacingResult.createInitialResult(
            configuration = CarRacingResultConfiguration(listOf(car1, car2), roundRange),
        )
        When("라운드별 자동차 위치를 조회하면") {
            val result = racingResult.showCarPositionsByRoundInOrder()
            Then("라운드 별 자동차 위치가 조횐된다") {
                roundRange.forEach { round ->
                    val index = round - 1
                    result[index] shouldBe listOf(0, 0)
                }
            }
        }
    }

    Given("자동차 경주 결과 초기값을 세팅하고") {
        val roundRange = 1..2
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val racingResult = CarRacingResult.createInitialResult(
            configuration = CarRacingResultConfiguration(listOf(car1, car2), roundRange),
        )
        And("자동차 경주 라운드 결과 값을 기록한 후") {
            val movedCar1 = Car(0, 1)
            val movedCar2 = Car(1, 2)
            val movedCars = listOf(movedCar1, movedCar2)
            racingResult.record(1, movedCars)
        }
        When("라운드별 자동차 위치를 조회하면") {
            val result = racingResult.showCarPositionsByRoundInOrder()
            Then("기록된 라운드 결과가 조횐된다") {
                result[0] shouldBe listOf(1, 2)
            }
            Then("기록되지 않은 라운드는 초기값이 조회된다") {
                result[1] shouldBe listOf(0, 0)
            }
        }
    }
})
