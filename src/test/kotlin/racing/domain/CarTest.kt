package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    given("자동차가") {
        `when`("전진 조건을 만족할때") {
            val car = Car()
            then("position이 증가한다.") {
                car.move()
                car.position shouldBe 1
            }
        }
        `when`("전진 조건을 만족하지 않았을떄") {
            val car = Car()
            then("position이 유지된다.") {
                car.position shouldBe 0
            }
        }
    }
})
