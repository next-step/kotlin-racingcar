package study

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ListTest : DescribeSpec({
    describe("fold") {
        listOf(1, 2, 3).fold(4) { acc, i -> acc + i } shouldBe 10
    }

    describe("reduce") {
        listOf(1, 2, 3).reduce { acc, i -> acc + i } shouldBe 6
    }
})
