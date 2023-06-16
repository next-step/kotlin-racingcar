package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car

class CarTest : BehaviorSpec({

    given(" 붕붕 카는 항상 이동하는 엔진으로") {
        var car = Car(_name = "붕붕")
        `when`("카 2번 이동하면 ") {
            car = car.move(4)
            car = car.move(4)
            then("카 의 위치는 2이다")
            car.position shouldBe 2
        }
        `when`("카 이름은 붕붕이로") {
            then("붕붕이다")
            car.name shouldBe "붕붕"
        }
    }

    given(" 사이클이 3이하 엔진으로 ") {
        val car = Car(_name = "bb")
        `when`("카를 움직이면") {
            car.move(3)
            then(" 카의 위치는 변하지 않는다.")
            car.position shouldBe Car.START_POSITION
        }
    }
})
