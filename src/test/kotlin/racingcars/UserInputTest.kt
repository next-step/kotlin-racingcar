package racingcars

import exception.NotImplementedTestException
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import racingcars.util.validInputToInt

class UserInputTest : DescribeSpec({

    describe("receives input from user") {
        context("input is null") {
            it("should throw an exception") {
                val str: String? = null

                val exception =
                    assertThrows<IllegalArgumentException> {
                        str.validInputToInt()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }

        context("input is blank") {
            it("should throw an exception") {
                val str = "  "

                val exception =
                    assertThrows<IllegalArgumentException> {
                        str.validInputToInt()
                    }
                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }

        context("input less than 1") {
            it("should throw an exception") {
                val exception =
                    assertThrows<IllegalArgumentException> {
                        "0".validInputToInt()
                    }
                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }

        context("when the input is not an Int type") {
            it("throws an exception for a String input") {
                val exception =
                    assertThrows<IllegalArgumentException> {
                        "str".validInputToInt()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }

            it("throws an exception for a Double input") {
                val exception =
                    assertThrows<IllegalArgumentException> {
                        "1.1".validInputToInt()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }

        context("input is a positive number") {
            it("test") {
                "10".validInputToInt() shouldBe 10
            }
        }
    }

    describe("displays input messages for car names and the number of attempts separately") {
        it("car input") {
            throw NotImplementedTestException()
        }

        it("attempts input") {
            throw NotImplementedTestException()
        }
    }
})
