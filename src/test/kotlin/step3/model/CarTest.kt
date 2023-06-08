package step3.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    test("car 는 전진할 수 있다.") {
        // given
        val car = Car(1)

        // when
        car.move()

        // then
        car.getPosition() shouldBe Car.FIRST_POSITION + 1
    }
})
