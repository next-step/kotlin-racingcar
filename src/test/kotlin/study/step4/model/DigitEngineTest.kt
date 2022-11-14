package study.step4.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class DigitEngineTest : StringSpec({
    "랜덤 숫자 엔진은, 주어진 숫자가 4 이상이면, true 를 반환한다" {
        listOf(
            4, 5, 6, 7, 8, 9
        ).forAll {
            val run = DigitEngine(StaticDigit(it)).run()

            run.shouldBeTrue()
        }
    }

    "랜덤 숫자 엔진은, 주어진 숫자가 4 미만이면, false 를 반환한다" {
        listOf(
            0, 1, 2, 3
        ).forAll {
            val run = DigitEngine(StaticDigit(it)).run()

            run.shouldBeFalse()
        }
    }
})
