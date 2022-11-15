package car_race.logic.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see CarNames
 */
class CarNamesTest : FunSpec({

    context("CarNames 단위 테스트") {
        test("이름을 쉼표를 기준으로 구분하여 생성합니다") {
            val inputCarNames = "car1,car2,car3"

            with(CarNames.from(inputCarNames).names) {
                this[0].getName() shouldBe "car1"
                this[1].getName() shouldBe "car2"
                this[2].getName() shouldBe "car3"
            }
        }
    }
})
