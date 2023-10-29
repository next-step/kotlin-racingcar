package step3_4.racing.car

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step3_4_5.racing.Car

class CarTest : StringSpec({
    "current_step이 기본 값을 잘 반환한다" {
        // given
        val carWithDefault = Car("p")
        val carWithAnotherValue = Car("p", 2)
        // when
        // then
        carWithDefault.currentStep() shouldBe 0
        carWithAnotherValue.currentStep() shouldBe 2
    }
    "Car의 이름이 세팅한 대로 잘 나온다" {
        // given
        val carWithDefault = Car("pita")
        // when
        // then
        carWithDefault.carName shouldBe "pita"
    }
    "Move Forward 함수가 잘 작동한다" {
        val carWithDefault = Car("pita")
        val carWithAnotherValue = Car("pita", 2)
        val expectedWithDefault = 1
        val expectedWithAnother = 3

        carWithDefault.moveForward()
        carWithAnotherValue.moveForward()

        carWithDefault.currentStep() shouldBe expectedWithDefault
        carWithAnotherValue.currentStep() shouldBe expectedWithAnother
    }
    "이름 5자 초과 에러 테스트" {
        val expectedMessage = "이름을 5자 이상 초과할 수 없어요."

        shouldThrowWithMessage<IllegalArgumentException>(expectedMessage) {
            Car("pitapat")
        }
    }
    "공백 제거" {
        val expectedMessage = "이름을 제대로 입력해 주세요."
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            Car("")
        }
    }
})
