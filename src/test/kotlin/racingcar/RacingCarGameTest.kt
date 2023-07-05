package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RacingCarGameTest : BehaviorSpec({

    Given("게임이 종료됐을때 Position의 값이 가장 큰 자동차가 우승자이다.") {
        val racingCars = RacingCars.of(mutableListOf(RacingCar("pobi"), RacingCar("pavlo"), RacingCar("wade")))
        val testAttemptNumber = 5
        When("경기를 시작한다.") {
            RacingCarsGame.startGame(racingCars, testAttemptNumber)
            Then("마지막에 포지션이 가장큰 값이 우승자이다.") {
                val winners = Winners(racingCars.getCars())
                val expect = racingCars.getCars().maxOf { it.position }
                winners.cars.map { it.position shouldBe expect }
            }
        }
    }
})
