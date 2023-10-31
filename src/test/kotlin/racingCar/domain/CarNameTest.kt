package racingCar.domain

import io.kotest.assertions.throwables.shouldNotThrowAnyUnit
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class CarNameTest : StringSpec({

    listOf(0, 6).forEach { length ->
        "자동차 이름의 길이가 ${length}면 예외가 발생한다." {
            shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 1글자 이상, 5글자 이하여야 합니다.") {
                CarName("a".repeat(length))
            }
        }
    }

    listOf(1, 2, 3, 4, 5).forEach { length ->
        "자동차 이름의 길이가 ${length}면 예외가 발생하지 않는다." {
            shouldNotThrowAnyUnit {
                CarName("a".repeat(length))
            }
        }
    }
})
