package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorManagerTest : DescribeSpec({
    lateinit var sut: CalculatorManger
    beforeTest { sut = CalculatorManger() }

    describe("A calculator that performs arithmetic operations based on the user's input string") {
        context("Not Null and Not Empty String") {
            it("should correctly perform the operations in the given sequence") {
                val input = "2 + 3 * 4 / 2"
                sut.start(input) shouldBe 10
            }
        }

        context("null String") {
            it("should throw an exception") {
                val input: String? = null

                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }
        }

        context("empty String") {
            it("empty string should throw an exception") {
                val input = ""

                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }

            it("blank string should throw an exception") {
                val input = "  "

                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }
        }

        context("not operational symbols") {
            it("should throw an exception") {
                val input = "2 + 3 * 4 & 2"

                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }
        }
    }

    describe("validateInput") {
        context("when input is null") {
            it("should throw an exception") {
                val input: String? = null
                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }
        }

        context("when input is empty") {
            it("should throw an exception") {
                val input = ""
                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }
        }

        context("when input is black") {
            it("should throw an exception") {
                val input = "  "
                shouldThrow<IllegalArgumentException> {
                    sut.start(input)
                }
            }
        }

        it("when the delimiter is at the first, should throw an exception") {
            val input = "+ 1 + 2 + 3"
            shouldThrow<IllegalArgumentException> {
                sut.start(input)
            }
        }

        it("when the delimiter is at the end, should throw an exception") {
            val input = "1 + 2 + 3 +"
            shouldThrow<IllegalArgumentException> {
                sut.start(input)
            }
        }

        it("when consecutive delimiters, should throw an exception") {
            val input = "1 ++ 2 - 3"
            shouldThrow<IllegalArgumentException> {
                sut.start(input)
            }
        }
    }
})
