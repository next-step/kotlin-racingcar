import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import ui.InputView

class GameManagerTest : DescribeSpec({
    lateinit var sut: GameManager

    beforeTest { sut = GameManager() }

    describe("RacingCar creation") {
        context("when user provides input for the number of cars") {
            it("should create the correct number of racing cars") {
                val inputView = InputView { "5" }
                val numberOfCars = inputView.readUserInput(UserInputType.NUMBER_OF_CARS)

                val cars = sut.createRacingCar(numberOfCars)
                cars.size shouldBe 5
            }
        }

        context("when user provides invalid input, should throw exception") {
            it("test1") {
                // given
                sut.inputView = InputView { "0" }

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.start()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요" // 예외 메시지 확인
            }

            it("test2") {
                // given
                sut.inputView = InputView { "ABC" }

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.start()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }
    }
})
