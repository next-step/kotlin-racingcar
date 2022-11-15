package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class PositionTest : StringSpec({
    "위치는 0이상이다" {
        listOf(0, 1, 2).forAll {
            shouldNotThrowAny { Position(it) }
        }
    }

    "위치는 0미만일 수 없다" {
        listOf(-1, -2, -3).forAll {
            shouldThrowAny { Position(it) }
        }
    }
})
