package step3

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import step3.ui.InputView
import step3.ui.ResultView

class GameManagerTest : DescribeSpec({
    lateinit var inputView: InputView
    lateinit var resultView: ResultView
    lateinit var randomNumberGenerator: RandomNumberGenerator
    lateinit var sut: GameManager

    beforeTest {
        inputView = InputView({ "5" })
        resultView = ResultView()
        randomNumberGenerator = FixedRandomNumberGenerator(5)
        sut = GameManager(inputView, resultView, randomNumberGenerator)
    }

    describe("create cars") {
        context("when user provides input for the number of cars") {
            it("should create the correct number of racing cars") {
                val userInput = inputView.getNumberOfCars()
                val cars = sut.createRacingCars(userInput)
                cars.size shouldBe 5
            }
        }
    }

    describe("playRound test") {
        it("random number greater than 3") {
            val mockCars = listOf(Car(id = 1), Car(id = 2))

            val actual = sut.playRound(mockCars)

            actual[0].position shouldBe 1
            actual[1].position shouldBe 1
        }

        it("random number less than 4") {
            val mockCars = listOf(Car(id = 1), Car(id = 2))

            sut.playRound(mockCars)

            mockCars[0].position shouldBe 0
            mockCars[1].position shouldBe 0
        }
    }

    describe("move to forward") {
        context("randomNumber equal to 4") {
            it("should to forward") {
                val car = Car(id = 1)
                randomNumberGenerator = FixedRandomNumberGenerator(4)
                val movedCar = sut.processCarMovement(car, randomNumberGenerator.generate())
                movedCar.position shouldBe 1
            }
        }

        context("randomNumber greater than 4") {
            it("should to forward") {
                val car = Car(id = 1)
                randomNumberGenerator = FixedRandomNumberGenerator(5)
                val movedCar = sut.processCarMovement(car, randomNumberGenerator.generate())
                movedCar.position shouldBe 1
            }
        }

        context("randomNumber less than 4") {
            it("should not move to forward") {
                val car = Car(id = 1)
                randomNumberGenerator = FixedRandomNumberGenerator(3)
                val movedCar = sut.processCarMovement(car, randomNumberGenerator.generate())
                movedCar.position shouldBe 0
            }
        }
    }

    describe("isMovable test") {
        context("less than 4") {
            it("parameter is negative value, should be false") {
                sut.isMovable(-1) shouldBe false
            }

            it("parameter is zero, should be false") {
                sut.isMovable(0) shouldBe false
            }

            it("parameter is 3, should be false") {
                sut.isMovable(3) shouldBe false
            }
        }

        context("greater than 3") {
            it("parameter is 4, should be thue") {
                sut.isMovable(4) shouldBe true
            }
            it("parameter is 5, should be thue") {
                sut.isMovable(5) shouldBe true
            }
            it("parameter is 999, should be thue") {
                sut.isMovable(999) shouldBe true
            }
        }
    }

    describe("moveForward") {
        it("should to forward car position") {
            val car = Car(id = 2)
            val firstMove = sut.moveForward(car)
            val secondMove = sut.moveForward(firstMove)
            val actual = sut.moveForward(secondMove)
            actual.position shouldBe 3
        }
    }
})
