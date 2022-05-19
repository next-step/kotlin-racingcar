package racingcar.domain.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class NameTest : StringSpec({
    "이름의 길이가 최소, 최대 길이 조건에 부합하면 정상적으로 이름 객체가 생성된다." {
        listOf(
            "a",
            "bbbbb"
        ).forAll {
            shouldNotThrowAny { Name(it) }
        }
    }

    "이름의 길이가 최소, 최대 길이 조건에 부합하지 않으면 이름 객체 생성시 예외를 발생시킨다." {
        listOf(
            "",
            "aaaaaa"
        ).forAll {
            shouldThrowExactly<IllegalArgumentException> { Name(it) }
        }
    }
})
