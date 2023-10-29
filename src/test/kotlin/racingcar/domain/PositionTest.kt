package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class PositionTest : ExpectSpec({

    expect("0 이상의 정수만을 가질 수 있다.") {
        val position1 = Position(0)
        position1.value shouldBe 0

        val position2 = Position(Int.MAX_VALUE)
        position2.value shouldBe Int.MAX_VALUE
    }

    expect("0 이하의 음수를 입력하면 오류가 발생한다.") {
        shouldThrowExactly<IllegalArgumentException> {
            Position(-1)
        }
    }
})
