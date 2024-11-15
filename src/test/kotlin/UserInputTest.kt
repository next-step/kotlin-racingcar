import exception.NotImplementedTestException
import io.kotest.core.spec.style.DescribeSpec

class UserInputTest : DescribeSpec({
    describe("receives input from user") {
        context("input is null") {
            it("should throw an exception") {
                throw NotImplementedTestException()
            }
        }

        context("input is blank") {
            it("should throw an exception") {
                throw NotImplementedTestException()
            }
        }

        context("input less than 1") {
            it("should throw an exception") {
                throw NotImplementedTestException()
            }
        }

        context("when the input is not an Int type") {
            it("throws an exception for a String input") {
                throw NotImplementedTestException()
            }

            it("throws an exception for a Double input") {
                throw NotImplementedTestException()
            }
        }

        context("input is a positive number") {
            it("returns the input as is") {
                throw NotImplementedTestException()
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
