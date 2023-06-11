package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race

class CarTest : BehaviorSpec({

    given("항상 이동하는 엔진으로") {
        val car = Car(engine = FakeEngine(CarTest.HIGH_CYCLE))
        `when`("카 2번 이동하면 ") {
            car.go()
            car.go()
            then("카 의 위치는 2이다")
            car.position shouldBe 2
        }
    }

    given(" 사이클이 3이하 엔진으로 ") {
        val car = Car(engine = FakeEngine(CarTest.LOW_CYCLE))
        `when`("카를 움직이면") {
            car.go()
            then(" 카의 위치는 변하지 않는다.")
            car.position shouldBe Car.START_POSITION
        }
    }
}) {
    companion object {
        const val LOW_CYCLE = 1
        const val HIGH_CYCLE = 10
    }
}
