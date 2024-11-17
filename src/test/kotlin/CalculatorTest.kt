import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    lateinit var sut: Calculator
    beforeTest { sut = Calculator() }

    describe("A calculator that performs arithmetic operations based on the user's input string") {
        context("Not Null and Not Empty String") {
            it("should correctly perform the operations in the given sequence") {
                val input = "2 + 3 * 4 / 2"
                sut.execute(input) shouldBe 10
            }
        }

        context("null String") {
            it("should throw an exception") {
                val input: String? = null

                shouldThrow<IllegalArgumentException> {
                    sut.execute(input)
                }
            }
        }

        context("empty String") {
            it("empty string should throw an exception") {
                val input = ""

                shouldThrow<IllegalArgumentException> {
                    sut.execute(input)
                }
            }

            it("blank string should throw an exception") {
                val input = "  "

                shouldThrow<IllegalArgumentException> {
                    sut.execute(input)
                }
            }
        }

        context("not operational symbols") {
            it("should throw an exception") {
                val input = "2 + 3 * 4 & 2"

                shouldThrow<IllegalArgumentException> {
                    sut.execute(input)
                }
            }
        }
    }
})
