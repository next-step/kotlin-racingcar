package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class OilTest : FunSpec({
    context("오일(연료) 비교 연산자 테스트") {
        test("크거나 같다. (>=)") {
            (Oil(amount = 4) >= Oil(amount = 3)) shouldBe true
            (Oil(amount = 3) >= Oil(amount = 4)) shouldBe false
        }

        test("작거나 같다. (<=)") {
            (Oil(amount = 3) <= Oil(amount = 4)) shouldBe true
            (Oil(amount = 4) <= Oil(amount = 3)) shouldBe false
        }

        test("크다. (>)") {
            (Oil(amount = 5) > Oil(amount = 3)) shouldBe true
            (Oil(amount = 3) > Oil(amount = 5)) shouldBe false
        }

        test("작다. (<)") {
            (Oil(amount = 3) < Oil(amount = 5)) shouldBe true
            (Oil(amount = 5) < Oil(amount = 3)) shouldBe false
        }
    }
})
