package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import racingcar.domain.Car
import racingcar.domain.RacingCarGame
import racingcar.model.GameInfo

class RacingCarGameTest : BehaviorSpec({

    val gameInfo = GameInfo(carNum = 3, trialNum = 5)
    val cars = List(gameInfo.carNum) { Car() }
    val initialDistanceOfCars = cars.map { car ->
        car.distance
    }

    Given("3대의 자동차가") {
        When("한 라운드를 진행하면") {
            val resultOfRound = RacingCarGame().proceedRound(cars)
            Then("3대의 자동차 각각은 주행 거리가 그대로이거나 1 증가한다.") {
                val resultDistanceOfCars = resultOfRound.map { car ->
                    car.distance
                }
                resultDistanceOfCars.forEachIndexed { index, distance ->
                    distance shouldBeIn listOf(initialDistanceOfCars[index], initialDistanceOfCars[index] + 1)
                }
            }
        }
    }
})
