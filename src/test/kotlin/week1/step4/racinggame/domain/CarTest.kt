package week1.step4.racinggame.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car는 4~9의 무작위 값을 받으면 한 칸 전진한다" {
        listOf(4, 5, 6, 7, 8, 9).forEach { randomNumber ->
            val sut = Car(CarName("pobi"))
            val initialPosition = sut.position

            sut.move(RandomNumber(randomNumber))

            val currentPosition = sut.position
            currentPosition shouldBe initialPosition + 1
        }
    }

    "Car는 0~3의 무작위 값을 받으면 그대로 멈춘다" {
        listOf(0, 1, 2, 3).forEach { randomNumber ->
            val sut = Car(CarName("pobi"))
            val initialPosition = sut.position

            sut.move(RandomNumber(randomNumber))

            val currentPosition = sut.position
            currentPosition shouldBe initialPosition
        }
    }

    "서로 다른 Car끼리 누가 승자인지 가릴 수 있다" {
        val winner = Car(CarName("alpha"), 1)
        val loser = Car(CarName("beta"), 0)

        winner.isWin(loser) shouldBe true
    }

    "서로 다른 Car 끼리 비겼는지 가릴 수 있다" {
        val car1 = Car(CarName("alpha"), 0)
        val car2 = Car(CarName("beta"), 0)

        car1.isDraw(car2) shouldBe true
    }
})
