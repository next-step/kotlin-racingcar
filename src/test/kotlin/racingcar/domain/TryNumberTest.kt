package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class TryNumberTest : StringSpec({
    "시도횟수가 1이상이면 정상적으로 객체를 생성한다." {
        listOf(
            1, 2, 3, 4,
        ).forAll {
            // when //then
            shouldNotThrowAny { TryNumber(it) }
        }
    }

    "시도횟수가 1미만이면 예외를 발생시킨다." {
        listOf(
            -3, -2, -1, 0,
        ).forAll {
            // when //then
            shouldThrowExactly<IllegalArgumentException> { TryNumber(it) }
        }
    }
})
