package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAnyUnit
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class TryCountTest : StringSpec({

    listOf(-1, 0).forEach { count ->
        "시도 횟수가 ${count}면 예외가 발생한다." {
            shouldThrowWithMessage<IllegalArgumentException>("시도 횟수는 1 이상이어야 합니다.") {
                TryCount(count)
            }
        }
    }

    "시도 횟수가 1 이상이면 예외가 발생하지 않는다." {
        shouldNotThrowAnyUnit {
            CarCount(1)
        }
    }
})
