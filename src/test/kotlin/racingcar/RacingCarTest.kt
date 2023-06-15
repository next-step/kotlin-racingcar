package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.RacingCar.Companion.FORWARD_POWER_NUMBER
import racingcar.RacingCar.Companion.MAXIMUM_POWER_NUMBER

class RacingCarTest : StringSpec({

    "움직이기 성공했을때의 차의 위치값 테스트" {
        val intRange = (FORWARD_POWER_NUMBER..MAXIMUM_POWER_NUMBER)
        intRange.forEach {
            val racingCar = RacingCar()
            racingCar.tryMove(it)
            racingCar.position shouldBe 1
        }
    }
})
