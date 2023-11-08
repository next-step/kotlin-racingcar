package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RaceExecutorTest : BehaviorSpec({
    given("입력받은 자동차 대수만큼 자동차 생성") {
        val cars = RaceExecutor.prepareCar(3)
        cars.size shouldBe 3
    }
})
