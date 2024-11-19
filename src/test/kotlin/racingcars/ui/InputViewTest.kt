package racingcars.ui

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : DescribeSpec({
    describe("Input from user") {
        context("when user provides invalid input") {
            it("number of car input value less than 1, should throw exception") {
                val sut = InputView { "0" }

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.getNumberOfCars()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요" // 예외 메시지 확인
            }

            it("number of car input value is not Int, should throw exception") {
                // given
                val sut = InputView { "ABC" }

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.getNumberOfCars()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }
    }
})
