package car_racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomNumberCarRacingManagerTest : StringSpec({
    "tryMoveCar 는 자동차 번호, 랜덤 숫자를 받아 전진 여부를 설정해준다" {
        // given
        val forwardRandomNumber = 4
        val randomNumberCarRacingManager = RandomNumberCarRacingManager(listOf(Car()))

        // when
        randomNumberCarRacingManager.tryMoveCar(0, forwardRandomNumber)

        // then
        randomNumberCarRacingManager.cars[0].distance shouldBe 1
    }

    "tryMoveCar 는 전진할수 없는 랜덤 숫자를 받으면 전진하지 않는다" {
        // given
        val stopRandomNumber = 1
        val randomNumberCarRacingManager = RandomNumberCarRacingManager(listOf(Car()))

        // when
        randomNumberCarRacingManager.tryMoveCar(0, stopRandomNumber)

        // then
        randomNumberCarRacingManager.cars[0].distance shouldBe 0
    }
})
