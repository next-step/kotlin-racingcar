package step3.racing.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step3.racing.Car

class CarTest : StringSpec({
    "current_step이 기본 값을 잘 반환한다" {
        // given
        val carWithDefault = Car()
        val carWithAnotherValue = Car(2)
        // when
        // then
        carWithDefault.currentStep() shouldBe 0
        carWithAnotherValue.currentStep() shouldBe 2
    }
})
