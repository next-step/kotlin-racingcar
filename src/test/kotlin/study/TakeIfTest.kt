package study

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TakeIfTest : DescribeSpec({

    /*
     takeIf / takeUnless 는 null 반환하기 때문에 무분별하게 사용하면 안됨
     null 다루는 함수에서만 사용하는 것이 좋아보임
     */
    describe("takeIf test") {
        it("`Predicate`를 받아서 조건에 만족하는 경우 자기 자신을 반환한다") {
            val number = 3
            number.takeIf { it % 3 == 0 } shouldBe 3
        }

        it("`Predicate`를 받아서 조건에 만족하지 않는 경우 null 반환한다") {
            val number = 3
            number.takeIf { it % 3 == 1 } shouldBe null
        }
    }

    describe("takeUnless test") {
        it("조건을 만족하면 null 반환") {
            val number = 3
            number.takeUnless { it % 3 == 0 } shouldBe null
        }

        it("조건을 만족하지 않으면 자기 자신 반환") {
            val number = 3
            number.takeUnless { it % 3 == 1 } shouldBe 3
        }
    }
})
