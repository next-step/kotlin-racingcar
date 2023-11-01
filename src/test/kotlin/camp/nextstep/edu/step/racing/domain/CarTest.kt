package camp.nextstep.edu.step.racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.lang.IllegalArgumentException

@DisplayName("자동차는")
class CarTest : BehaviorSpec ({

    Given("자동차 이름이 주어지면") {
        val carName = "현대모비스 레이싱카"

        When("자동차를 생성하고") {
            val car = Car(carName = carName)

            Then("주어진 이름의 자동차가 생성된다") {
                car shouldBe Car(carName = "현대모비스 레이싱카")
                car.carName shouldBe "현대모비스 레이싱카"
            }
        }
    }

    Given("만약 자동차 이름이 없는데") {
        val carName = ""

            When("자동차를 생성하면") {
                val car = shouldThrow<IllegalArgumentException> {
                    Car(carName = carName)
                }

                Then("예외가 발생한다") {
                    car.message shouldBe "자동차의 이름이 비어있습니다."
                }
            }
    }

})
