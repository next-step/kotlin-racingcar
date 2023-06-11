package step3.racingcar.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class RacingGameServiceTest : StringSpec({
    val racingGameService = RacingGameService()

    "시도 횟수가 0이하일 때, 예외가 발생한다." {
        val count = 0

        shouldThrow<IllegalArgumentException> {
            racingGameService.initAttemptCount(count)
        }
    }
})
