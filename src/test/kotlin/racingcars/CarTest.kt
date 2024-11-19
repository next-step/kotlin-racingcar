package racingcars

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({
    lateinit var sut: Car

    describe("isMovableTest") {
        beforeTest { sut = Car(id = 1) }
        context("when random number greater than 4 or equals to 4") {
            it("should be true") {
                val randomNumber = 5
                sut.moveForward(randomNumber)
                sut.position shouldBe 1
            }
        }

        context("when random number equals to 4") {
            it("should be true") {
                val randomNumber = 4
                sut.moveForward(randomNumber)
                sut.position shouldBe 1
            }
        }

        context("when random number less than 4") {
            it("should be false") {
                val randomNumber = 3
                sut.moveForward(randomNumber)
                sut.position shouldBe 0
            }
        }
    }
})
