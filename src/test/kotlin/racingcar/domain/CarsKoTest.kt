package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe

class CarsKoTest : StringSpec({
    val carNames = listOf("AA", "BB", "cc")

    val moveCondition = object : MoveCondition {
        override fun isMovable(): Boolean {
            return true
        }
    }

    "주어진 개수만큼 자동차 객체가 생성되어야한다" {
        val cars = Cars(carNames, moveCondition)
        cars.countCars() shouldBe 3
    }

    "시도한 횟수만큼 위치가 증가한다." {
        val attemptCount = 3
        val cars = Cars(carNames, moveCondition)
        repeat(attemptCount) {
            cars.attempt()
        }
        cars.carList.forEach {
            it.position shouldBe attemptCount
        }
    }

    "우승자가 한명 이상 존재한다." {
        val attemptCount = 3
        val cars = Cars(carNames, moveCondition)
        repeat(attemptCount) {
            cars.attempt()
        }
        cars.getWinners() shouldHaveAtLeastSize 1
    }
})
