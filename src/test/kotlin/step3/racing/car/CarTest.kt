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

    "앞으로 움직이면 step이 +1이 잘 된다" {
        // given
        val car = Car()
        // when
        val expected = car.currentStep() + 1
        car.moveForward()
        // then
        expected shouldBe car.currentStep()
    }
})
