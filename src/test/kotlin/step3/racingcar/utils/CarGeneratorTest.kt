package step3.racingcar.utils

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step3.racingcar.domain.Cars

internal class CarGeneratorTest : BehaviorSpec({
    given("CarGenerator") {
        `when`("특정 숫자가 주어지면") {
            val actual: Cars = CarGenerator.generate(5)
            then("숫자만큼 자동차가 생성된다.") {
                actual.size() shouldBe 5
            }
        }
    }
})
