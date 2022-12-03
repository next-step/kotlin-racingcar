package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.Judges
import racingcar.domain.Name

class JudgesTest : BehaviorSpec({

    val car1 = Car(name = Name.of("pobi"), distance = 3)
    val car2 = Car(name = Name.of("crong"), distance = 5)
    val car3 = Car(name = Name.of("honux"), distance = 5)
    val cars = listOf(car1, car2, car3)

    Given("심판이 차 리스트를 받으면") {
        val judges = Judges(cars = cars)
        When("우승자를 선정할 때") {
            val result = judges.pickWinner()
            Then("최대 거리를 주행한 자동차를 우승자로 뽑는다.") {
                result shouldBe listOf(car2, car3)
            }
        }
    }
})
