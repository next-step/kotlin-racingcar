package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class PositionTest : StringSpec({
    "입력 값이 0이상이면 객체가 생성된다" {
        listOf(0, 1, 2).forAll {
            shouldNotThrowAny { Position(it) }
        }
    }

    "입력 값이 음수면 예외가 발생한다" {
        listOf(-1, -2, -3).forAll {
            shouldThrowAny { Position(it) }
        }
    }
})
