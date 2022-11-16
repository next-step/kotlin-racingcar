package racingcar.application.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class RaceInputCommandTest : StringSpec({
    "레이스에게 커맨드를 전달하는 객체의 자동차 개수는 0보다 커야 한다." {
        shouldThrow<IllegalArgumentException> { RaceInputCommand(carNames = listOf(), attemptCount = 1) }
    }

    "레이스에게 커맨드를 전달하는 객체의 시도 횟수는 0보다 커야 한다." {
        shouldThrow<IllegalArgumentException> { RaceInputCommand(carNames = listOf("ep", "nak"), attemptCount = -1) }
    }
})
