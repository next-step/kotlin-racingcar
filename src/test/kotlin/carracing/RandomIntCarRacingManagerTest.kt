package carracing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomIntCarRacingManagerTest : StringSpec({
    val randomIntRacingMovementRole = RandomIntRacingMovementRole(4, 1, 9)

    "랜덤 값이 4 이상인 경우 자동차가 1 전진한다" {
        // given
        val nowDistance = 1
        val randomIntCarRacingManager =
            RandomIntCarRacingManager(CarList(listOf(Car(nowDistance))), randomIntRacingMovementRole)
        val moveRandomInt = 4

        // when
        randomIntCarRacingManager.tryMoveCar(0, moveRandomInt)
        val randomIntCarList = randomIntCarRacingManager.getCarList()

        // then
        randomIntCarList[0].distance shouldBe nowDistance + 1
    }

    "랜덤 값이 4 미만인 경우 자동차가 멈춘다" {
        // given
        val nowDistance = 40
        val randomIntCarRacingManager =
            RandomIntCarRacingManager(CarList(listOf(Car(nowDistance))), randomIntRacingMovementRole)
        val stopRandomInt = 2

        // when
        randomIntCarRacingManager.tryMoveCar(0, stopRandomInt)
        val randomIntCarList = randomIntCarRacingManager.getCarList()

        // then
        randomIntCarList[0].distance shouldBe nowDistance
    }
})
