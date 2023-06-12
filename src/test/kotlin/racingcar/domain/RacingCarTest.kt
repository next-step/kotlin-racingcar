package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingCarTest : StringSpec({

    "random 결과가 4 미만일 경우 전진을 하지 못한다." {
        val racingCar = RacingCar(1)
        val result = racingCar.carProgress { 3 }
        result.progress shouldBe 1
    }

    "random 결과가 4 이상일 경우 전진을 한다." {
        val racingCar = RacingCar(1)
        val result = racingCar.carProgress { 5 }
        result.progress shouldBe 2
    }
})
