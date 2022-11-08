package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class MoveStatusTest : BehaviorSpec({
    given("MoveStatus : 주어진 숫자에 따른 전진/멈춤 판별") {
        `when`("주어진 숫자가 4이상 이면") {
            val actual = MoveStatus.match(4)
            then("전진 상태를 반환한다.") {
                actual shouldBe MoveStatus.ACCELERATION
            }
        }
        `when`("주어진 숫자가 4 미만 이면") {
            val actual = MoveStatus.match(3)
            then("멈춤 상태를 반환한다.") {
                actual shouldBe MoveStatus.BREAK
            }
        }
    }
})
