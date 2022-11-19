package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class OilPolicyTest : FunSpec({
    context("자동차 주행 오일 정책") {
        context("충분한 오일이 주어지면") {
            test("자동차는 주행할 수 있다.") {
                // given
                val oilPolicy = OilPolicy(oil = Oil(amount = 4))
                // when & then
                oilPolicy.canMove() shouldBe true
            }
        }

        context("부족한 오일이 주어지면") {
            test("자동차는 주행할 수 없다.") {
                // given
                val oilPolicy = OilPolicy(oil = Oil(amount = 3))
                // when & then
                oilPolicy.canMove() shouldBe false
            }
        }
    }
})
