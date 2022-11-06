package nexstep.mission.racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingCarTest : FunSpec({

    test("경주 자동차를 생성한다. 기본 position은 0이다.") {
        val racingCar = RacingCar()
        racingCar.position shouldBe 0
    }
})
