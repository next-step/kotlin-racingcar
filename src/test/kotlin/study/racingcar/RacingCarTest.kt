package study.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.RacingCar

class RacingCarTest : StringSpec({
    "값이 4 이상일 경우 전진한다." {
        RacingCar.checkMoveAvailable(4) shouldBe true
    }

    "값이 4 미만일 경우 정지한다." {
        RacingCar.checkMoveAvailable(2) shouldBe false
    }
})
