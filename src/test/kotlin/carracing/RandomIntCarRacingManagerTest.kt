package carracing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomIntCarRacingManagerTest : StringSpec({
    val racingMovementRoleByInt = RacingMovementRoleByInt(4, 1, 9)
    "Input Dto 로 클래스를 생성할수 있는 팩토리를 지원한다" {
        // given
        val inputDto = InputDto("11", "3")

        // when
        val randomIntCaRacingManger = RandomIntCarRacingManager.fromInputDto(inputDto, racingMovementRoleByInt)
        val carSize = randomIntCaRacingManger.getCarSize()

        // then
        carSize shouldBe 11
    }

    "랜덤 값이 4 이상인 경우 자동차가 1 전진한다" {
        // given
        val nowDistance = 1
        val randomIntCarRacingManager =
            RandomIntCarRacingManager(CarList(listOf(Car(nowDistance))), racingMovementRoleByInt)
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
            RandomIntCarRacingManager(CarList(listOf(Car(nowDistance))), racingMovementRoleByInt)
        val stopRandomInt = 2

        // when
        randomIntCarRacingManager.tryMoveCar(0, stopRandomInt)
        val randomIntCarList = randomIntCarRacingManager.getCarList()

        // then
        randomIntCarList[0].distance shouldBe nowDistance
    }
})
