package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class RoundTest : ExpectSpec({

    expect("1 이상 100 이하의 정수만을 가질 수 있다.") {
        val round1 = Round(1)
        round1.value shouldBe 1

        val round2 = Round(100)
        round2.value shouldBe 100
    }

    expect("0 이하의 음수를 입력하면 오류가 발생한다.") {
        shouldThrowExactly<IllegalArgumentException> {
            Round(-1)
        }
    }

    expect("next() 함수를 통해 다음 라운드를 생성할 수 있다.") {
        val round = Round(1)
        round.next().value shouldBe 2
    }
})
