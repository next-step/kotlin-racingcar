package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingLapTest : StringSpec({

    "목표한 레이싱 시도 횟수만큼 깃발을 흔들고 나면 경기 종료를 알린다." {
        // given
        val goalLapValue = 3
        val racingLap = RacingLap(goalLapValue)

        // when
        for (i in 1..goalLapValue) {
            racingLap.isNotFinished() shouldBe true
            racingLap.waveTheFlag()
        }

        // then
        racingLap.isNotFinished() shouldBe false
    }

    "레이싱 시도가 ${RacingLap.MIN_RACING_LAP} 보다 작으면 예외가 발생한다." {
        // given
        val invalidValue = RacingLap.MIN_RACING_LAP - 1

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> { RacingLap(goalLap = invalidValue) }

        // then
        exception.message shouldBe "레이싱 시도 횟수는 최소 ${RacingLap.MIN_RACING_LAP} 이상이어야 합니다."
    }
})
