package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.comparables.shouldBeLessThanOrEqualTo
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll


class `랜덤 숫자 생성 테스트` : BehaviorSpec({

    Given("랜덤 숫자를 반환하는 객체가 주어질 때") {
        When("시작 숫자와 끝 숫자를 지정할 경우") {
            Then("시작 숫자 이상, 끝 숫자 이하의 랜덤한 수가 반환된다.") {
                checkAll(Arb.int(0, 100), Arb.int(100, 200)) { a, b ->
                    val actual = RandomNumberGenerator.generate(a, b)
                    actual shouldBeLessThanOrEqualTo b
                    actual shouldBeGreaterThanOrEqualTo a
                }
            }
        }
    }
})
