package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeInstanceOf

class InputParserKoTest : DescribeSpec({
    describe("입력값 파싱 테스트") {
        it("정상적인 입력값에 대한 테스트") {
            val input = "2 + 3 * 4 / 2"
            val expectedResult = listOf("2", "+", "3", "*", "4", "/", "2")

            val parsedInput = InputParser.parse(input)
            parsedInput.shouldBeInstanceOf<List<String>>()
            parsedInput.shouldHaveSize(7)
            parsedInput shouldBe expectedResult
        }

        it("빈 입력값에 대한 익셉션 테스트") {
            val input = " "

            val exception = shouldThrow<IllegalArgumentException> {
                InputParser.parse(input)
            }
            exception.message should startWith("Input value cannot be null or blank.")
        }

        it("널 입력값에 대한 익셉션 테스트") {
            val exception = shouldThrow<IllegalArgumentException> {
                InputParser.parse(null)
            }
            exception.message should startWith("Input value cannot be null or blank.")
        }
    }
})
