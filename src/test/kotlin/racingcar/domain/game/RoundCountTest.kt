package racingcar.domain.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class RoundCountTest : FunSpec({
    test("경기 횟수가 생성된다") {
        val number = 9

        val result = RoundCount(number)

        result.value shouldBe number
    }

    test("경기 횟수가 0보다 작으면 생성에 실패한다") {
        val number = -1

        shouldThrow<IllegalArgumentException> {
            RoundCount(number)
        }
    }
})
