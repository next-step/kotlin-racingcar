package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingCarGameTest : BehaviorSpec({

    Given("게임이 종료됐을때 Position의 값이 가장 큰 자동차가 우승자이다.") {
        val racingCars = RacingCars(mutableListOf(RacingCar("pobi"), RacingCar("pavlo"), RacingCar("wade")))
        val testAttemptNumber = 5
        When("경기를 시작한다.") {
            startGame(racingCars, testAttemptNumber)
            Then("마지막에 포지션이 가장큰 값이 우승자이다.") {
                val winners = Winners(racingCars.cars)
                val expect = racingCars.cars.maxOf { it.position }
                winners.cars.map { it.position shouldBe expect }
            }
        }
    }

    Given("시도하는 횟수가 0 보다 작은 숫자나 공백이 들어오면 에러") {
        When("0보다 작은 숫자나 공백이 들어온다.") {
            listOf("-1", "^^", "")
                .forAll {
                    Then("IllegalArgumentException 이 발생한다.") {
                        shouldThrow<IllegalArgumentException> {
                            getIntValue(it)
                        }
                    }
                }
        }
    }
})
