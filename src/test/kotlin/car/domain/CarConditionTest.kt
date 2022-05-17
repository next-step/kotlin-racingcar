package car.domain

import car.domain.CarCondition
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarConditionTest : FreeSpec({
    "자동차 상태는" - {
        "좋은경우 앞으로 이동한다" {
            CarCondition.GOOD.canGoForward() shouldBe true
        }
        "나쁜경우 앞으로 이동하지 못한다" {
            CarCondition.TERRIBLE.canGoForward() shouldBe false
        }
    }
})
