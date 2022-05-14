package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingLapTest : StringSpec({

    "목표한 경주랩만큼 깃발을 흔들고 나면 경기 종료를 알린다." {
        // given
        val goalLapValue = 3
        val racingLap = RacingLap(goalLapValue)

        // when
        for (i in 1..goalLapValue) {
            racingLap.isFinished() shouldBe false
            racingLap.waveTheFlag()
        }

        // then
        racingLap.isFinished() shouldBe true
    }
})
