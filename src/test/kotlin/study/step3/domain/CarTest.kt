package study.step3.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("차 위치 기본값은 0이다") {
        val car = Car()
        `when`("차가 이동할 때 값이 위치 값이 1 증가한다.") {
            val oldPosition = car.position
            car.move()
            then("위치 값은 기존 값 보다 1증가한다.") {
                oldPosition shouldBe 0
                car.position shouldBe oldPosition + 1
            }
        }

        `when`("차는 Response 객체로 변경 가능하다.") {
            val response = car.toResponseByCar()
            then("리스폰스 객체는 차의 값을 그대로 같고 있으며, 위치를 프린트 할 수 있다.") {
                response.position shouldBe car.position
                response.getPositionRepresentation() shouldBe "-"
            }
        }
    }
})
