package util.racing.converter

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PositionSymbolConverterKoTest : DescribeSpec({
    describe("method test") {
        context("convert test") {
            listOf(0, 1, 2, 3, 4, 5).forEach {
                it("position에 맞게 symbol이 출력된다") {
                    PositionSymbolConverter.converter(it) shouldBe "-".repeat(it)
                }
            }
        }
    }
})
