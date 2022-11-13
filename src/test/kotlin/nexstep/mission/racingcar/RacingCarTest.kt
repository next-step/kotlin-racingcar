package nexstep.mission.racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingCarTest : FunSpec({

    test("경주 자동차를 생성한다. 기본 position은 0이다.") {
        val racingCar = RacingCar("pobi")
        racingCar.position() shouldBe 0
    }

    test("4이상일 경우 자동차는 이동한다.") {
        val racingCar = RacingCar("jason")
        racingCar.move(4)

        racingCar.position() shouldBe 1
    }

    test("4미만 경우 자동차는 이동하지 않는다.") {
        val racingCar = RacingCar("brown")
        racingCar.move(3)

        racingCar.position() shouldBe 0
    }
})
