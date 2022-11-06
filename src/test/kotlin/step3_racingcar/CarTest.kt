package step3_racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step3_racingcar.strategy.ForwardStrategy
import step3_racingcar.util.random.RandomNumber

class CarTest : BehaviorSpec({
    given("자동차가") {
        `when`("전진 조건을 만족할 때") {
            val car = Car(strategy = ForwardStrategy(RandomNumber(greaterThanOrEquals4Range)))
            then("distance 가 증가한다.") {
                car.move()
                car.distance shouldBe 1
            }
        }

        `when`("전진 조건을 만족하지 않을 때") {
            val car = Car(strategy = ForwardStrategy(RandomNumber(lessThan4Range)))
            then("distance 는 변화가 없다.") {
                car.move()
                car.distance shouldBe 0
            }
        }
    }
}) {
    companion object {
        private val lessThan4Range = (0..3)
        private val greaterThanOrEquals4Range = (4..9)
    }
}
