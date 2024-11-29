package racingcars.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class CarTest : DescribeSpec({
    lateinit var sut: Car

    describe("isMovableTest") {
        beforeTest { sut = Car(id = 1, name = "default") }
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

    describe("fromInput") {
        context("when numberOfCar equals to carNames") {
            it("should create car lists") {
                val numberOfCar = 2
                val carNamesInput = "pobi,crong"
                val cars = Car.fromInput(numberOfCar, carNamesInput)
                cars.size shouldBe 2
                cars[0].name shouldBe "pobi"
                cars[1].name shouldBe "crong"
            }
        }

        context("when numberOfCar not equals to carNames") {
            it("should create car lists") {
                val numberOfCar = 3
                val carNamesInput = "pobi,crong"
                assertThrows<IllegalArgumentException> {
                    Car.fromInput(numberOfCar, carNamesInput)
                }
            }
        }
    }
})
