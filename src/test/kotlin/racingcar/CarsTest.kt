package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({

    given("항상 움직이는 전략을 가진 2대의 자동차가") {
        val cars = Cars(listOf("a", "b").map { Car(name = it, strategy = { true }) })

        `when`("5번의 시도횟수를 가지면") {
            val tryCount = 5
            cars.game(tryCount)

            then("5번 전진한다.") {
                cars.getCars().forEach {
                    it.getDistance() shouldBe 5
                }
            }
        }
    }

    given("3대의 자동차가 (2대는 무조건 전진전략, 1대는 무조건 움직이지않는 전략을 가짐)") {
        val car1 = Car(name = "a", strategy = { true })
        val car2 = Car(name = "b", strategy = { true })
        val car3 = Car(name = "c", strategy = { false })
        val cars = Cars(listOf(car1, car2, car3))

        `when`("3번의 경주를 해서 2대가 가장 높은 점수(distance)를 가졌다면") {
            cars.game(3)

            then("2명의 우승자가 나온다.") {
                cars.getWinners().size shouldBe 2
            }
        }
    }

    given("3대의 자동차가 (모든 자동차가 움직이지 않는 전략을 가짐)") {
        val car1 = Car(name = "a", strategy = { false })
        val car2 = Car(name = "b", strategy = { false })
        val car3 = Car(name = "c", strategy = { false })
        val cars = Cars(listOf(car1, car2, car3))

        `when`("3번의 경주를 했을 때") {
            cars.game(3)

            then("우승자는 0명이어야 한다.") {
                cars.getWinners().size shouldBe 0
            }
        }
    }
})
