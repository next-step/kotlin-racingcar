package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : BehaviorSpec({
    given("Cars") {
        `when`("특정 숫자가 주어지면") {
            val actual = Cars(5)
            then("숫자만큼 자동차가 생성된다.") {
                actual.size() shouldBe 5
            }
        }
    }
})
