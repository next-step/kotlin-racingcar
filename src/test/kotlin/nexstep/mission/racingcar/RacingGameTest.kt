package nexstep.mission.racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forExactly
import io.kotest.matchers.types.shouldBeTypeOf

class RacingGameTest : FunSpec({

    test("입력받은 갯수만큼 경주 자동차를 생성한다.") {
        val result = RacingGame.createRacingCars(10)
        result.forExactly(10) {
            it.shouldBeTypeOf<RacingCar>()
        }
    }
})
