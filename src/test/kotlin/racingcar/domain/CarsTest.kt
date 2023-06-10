package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.util.OrderNumberGenerator

class CarsTest : BehaviorSpec({
    given("moveAll 메소드") {
        val cars = Cars(OrderNumberGenerator(3, 4), 2)
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                cars.moveAll()
                cars.first().getPosition() shouldBe 1
                cars.last().getPosition() shouldBe 2
            }
        }
    }
})
