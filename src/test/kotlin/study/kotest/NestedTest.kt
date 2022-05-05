package study.kotest

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NestedTest : DescribeSpec({

    describe("외부 테스트") {
        it("내부 테스트") {
            1 + 2 shouldBe 3
        }

        it("내부 테스트 2"){
            3 +4 shouldBe 7
        }
    }
})