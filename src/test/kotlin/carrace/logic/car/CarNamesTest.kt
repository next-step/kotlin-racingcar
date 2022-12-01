package carrace.logic.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see CarNames
 */
internal class CarNamesTest : FunSpec({

    context("CarNames 단위 테스트") {
        test("이름을 쉼표를 기준으로 구분하여 생성합니다") {
            val inputCarNames = "car1,car2,car3"

            with(CarNames(inputCarNames).names) {
                this[0].name shouldBe "car1"
                this[1].name shouldBe "car2"
                this[2].name shouldBe "car3"
            }
        }
    }
})
