package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class NameTest : StringSpec({
    "자동차 이름은 5자이하 이다" {
        listOf("", " ", "a", "ab", "abc", "abcd", "abcde")
            .forAll {
                shouldNotThrowAny { Name(it) }
            }
    }

    "자동차 이름은 5자를 초과할 수 없다" {
        listOf("      ", "abcde ", "abcdef", "a cdef")
            .forAll {
                shouldThrowAny { Name(it) }
            }
    }
})
