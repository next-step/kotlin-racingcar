package racingcar.domain.result

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car

class CarRacingRoundResultTest : BehaviorSpec({
    Given("자동차 경주 라운드 결과 초기값만 세팅하고") {
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val roundResult = CarRacingRoundResult.createInitialResult(listOf(car1, car2))
        When("자동차 경주 라운드 결과 값을 조회하면") {
            val car1Result = roundResult.getCarPosition(0)
            val car2Result = roundResult.getCarPosition(1)
            Then("세팅된 초기값이 조회된다") {
                car1Result shouldBe 0
                car2Result shouldBe 0
            }
        }
    }

    Given("자동차 경주 라운드 결과를 셍성하고") {
        val car1 = Car(0, 0)
        val car2 = Car(1, 0)
        val roundResult = CarRacingRoundResult.createInitialResult(listOf(car1, car2))
        When("등록되지 않은 자동차 경주 결과 값을 조회하면") {
            Then("조회에 실패한다") {
                shouldThrowExactly<IllegalArgumentException> {
                    roundResult.getCarPosition(2)
                }
            }
        }
    }

    Given("자동차 경주 라운드 초기값을 세팅하고") {
        val initialCar1 = Car(0, 0)
        val initialCar2 = Car(1, 0)
        val initialCars = listOf(initialCar1, initialCar2)
        val roundResult = CarRacingRoundResult.createInitialResult(initialCars)
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

    Given("자동차 경주 결과에 차를 등록했을 때") {
        val initialCar1 = Car(0, 0)
        val initialCar2 = Car(1, 0)
        val initialCars = listOf(initialCar1, initialCar2)
        val roundResult = CarRacingRoundResult.createInitialResult(initialCars)
        When("등록한 차가 아닌 다른 차의 자동차 경주 라운드 결과 값을 기록하면") {
            val movedCars = listOf(
                Car(0, 1),
                Car(1, 2),
                Car(2, 1),
            )
            Then("기록에 실패한다") {
                shouldThrowExactly<IllegalArgumentException> {
                    roundResult.record(movedCars)
                }
            }
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

    Given("자동차 경주 라운드 결과를 기록하고") {
        val roundResult = CarRacingRoundResult.createInitialResult(listOf(Car(0, 0), Car(1, 0)))
        val movedCar1 = Car(0, 1)
        val movedCar2 = Car(1, 2)
        val movedCars = listOf(movedCar1, movedCar2)
        roundResult.record(movedCars)
        When("자동차 경주 라운드 결과 값 리스트를 조회하면") {
            val result = roundResult.getCarPositionsInorder()
            Then("기록된 라운드 결과가 리스트로 조회된다") {
                result shouldBe listOf(1, 2)
            }
        }
    }
})
