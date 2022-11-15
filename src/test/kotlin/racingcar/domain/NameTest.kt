package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class NameTest : BehaviorSpec({
    given("이름을 입력할 때") {
        `when`("10자 이상의 문자열을 입력하면") {
            val input = "윤영빈윤영빈윤영빈윤영빈"

            then("IllegalArgumentException 이 발생한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Name(input)
                }
                exception.message shouldBe startWith("이름은 10자 이하여야 합니다.")
            }
        }
    }
})
