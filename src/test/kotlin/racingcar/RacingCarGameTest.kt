package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.RacingCarGame

class RacingCarGameTest : BehaviorSpec({

    val racingCarGame = RacingCarGame()
    val car1 = Car(name = "pobi", distance = 3)
    val car2 = Car(name = "crong", distance = 5)
    val car3 = Car(name = "honux", distance = 5)
    val cars = listOf(car1, car2, car3)

    Given("자동차 경주 게임이 끝나") {
        When("최댓값을 구해 우승자를 정하면") {
            val result = racingCarGame.pickWinner(
                max = cars.maxOf { car ->
                    car.distance
                },
                cars = cars
            )
            Then("최댓값과 같은 거리 값을 가진 자동차가 우승한다.") {
                result shouldBe listOf(car2, car3)
            }
        }
    }
})
