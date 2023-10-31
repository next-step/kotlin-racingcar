package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.strategy.RandomMoveStrategy
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("자동차 서비스는")
class CarServiceTest : BehaviorSpec ({
    val carService = CarService(RandomMoveStrategy())

    Given("자동차 이름이 주어지고") {
        val hyundaiCarName = "현대자동차"
        val kiaCarName = "기아자동차"

        When("자동차를 생성하면") {
            val hyundaiCar = carService.createCarByInput(inputCarValue = hyundaiCarName)
            val kiaCar = carService.createCarByInput(inputCarValue = kiaCarName)

            Then("요청한 이름의 자동차가 생성된다") {
                hyundaiCar.carName shouldBe "현대자동차"
                kiaCar.carName shouldBe "기아자동차"
            }
        }
    }

})
