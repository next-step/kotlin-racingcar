package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class UtilTest : DescribeSpec({
    describe("groupByIsNumber") {
        it("true 를 받으면 숫자인 요소를 배열로 리턴한다.") {
            val inputs = listOf<String>("1", "+", "2", "-", "3")
            val inputs2 = listOf<String>("1", "+", "2", "-", "3", "4")

            val result = Util.groupByIsNumber(inputs, true)
            val result2 = Util.groupByIsNumber(inputs2, true)

            result shouldBe listOf<String>("1", "2", "3")
            result2 shouldBe listOf<String>("1", "2", "3", "4")
        }

        it("false 를 받으면 숫자가 아닌 요소를 배열로 리턴한다.") {
            val inputs = listOf<String>("1", "+", "2", "-", "3")
            val inputs2 = listOf<String>("1", "+", "2", "-", "3", "4")

            val result = Util.groupByIsNumber(inputs, false)
            val result2 = Util.groupByIsNumber(inputs2, false)

            result shouldBe listOf<String>("+", "-")
            result2 shouldBe listOf<String>("+", "-")
        }
    }
})
