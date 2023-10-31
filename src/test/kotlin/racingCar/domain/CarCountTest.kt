package racingCar.domain

import io.kotest.assertions.throwables.shouldNotThrowAnyUnit
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class CarCountTest : StringSpec({

    listOf(-1, 0).forEach { count ->
        "자동차의 개수가 ${count}면 예외가 발생한다." {
            shouldThrowWithMessage<IllegalArgumentException>("자동차 개수는 1 이상이어야 합니다.") {
                CarCount(count)
            }
        }
    }

    "자동차의 개수가 1 이상이면 예외가 발생하지 않는다." {
        shouldNotThrowAnyUnit {
            CarCount(1)
        }
    }
})
