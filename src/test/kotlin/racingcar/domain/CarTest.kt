package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.strategy.RandomForwardStrategy
import racingcar.util.random.RandomNumber

class CarTest : BehaviorSpec({
    given("자동차가") {
        `when`("전진 조건을 만족할 때") {
            val car = Car(
                name = NAME,
                strategy = RandomForwardStrategy(RandomNumber(greaterThanOrEquals4Range)),
                distance = Distance()
            )
            then("distance 가 증가한다.") {
                car.moveOrNot().getDistance() shouldBe 1
            }
        }

        `when`("전진 조건을 만족하지 않을 때") {
            val car = Car(
                name = NAME,
                strategy = RandomForwardStrategy(RandomNumber(lessThan4Range)),
                distance = Distance()
            )
            then("distance 는 변화가 없다.") {
                car.moveOrNot()
                car.getDistance() shouldBe 0
            }
        }
    }
}) {
    companion object {
        private val lessThan4Range = (0..3)
        private val greaterThanOrEquals4Range = (4..9)
        private val NAME = Name("tester")
    }
}
