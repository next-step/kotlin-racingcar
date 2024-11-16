package study

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class IntOrNullTest : DescribeSpec({
    describe("변환할 수 없는 경우 null을 반환한다") {
        context("변환할 수 없는 문자열인 경우") {
            lateinit var str: String
            beforeTest { str = "ABC" }

            it("test1") {
                str.toIntOrNull() shouldBe null
            }
        }

        context("null인 경우") {
            val str: String? = null
            it("test1") {
                str?.toIntOrNull() shouldBe null
            }
        }
    }

    describe("변환할 수 있는 경우 Int로 변환한다") {
        lateinit var str: String
        beforeTest { str = "1" }

        it("test1") {
            str.toIntOrNull() shouldBe 1
        }
    }
})
