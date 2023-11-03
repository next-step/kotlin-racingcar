package racingcar.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CapturedCarTest : FunSpec({
    test("자동차로부터 캡쳐가 생성된다") {
        val car = Car(name = CarName("test1"), position = 10)

        val result = CapturedCar(car)

        result.name shouldBe car.name
        result.position shouldBe car.position
    }
})
