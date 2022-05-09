package study.kotest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength

class BDDTest : BehaviorSpec({

    given("숫자 1과 3 주어졌을 때") {
        val firstNumber = 1
        val secondNumber = 3
        `when`("두 숫자를 + 연산을 수행하면") {
            val actual = firstNumber + secondNumber
            then("결과 값은 4를 반환한다") {
                actual shouldBe 4
            }
        }
    }

    given("여러 세 글자 이름의 이 주어졌을 때") {
        val names = listOf(
            "sam",
            "pam",
            "tom"
        )
        then("길이는 3이다") {
            names.forEach {
                it.shouldHaveLength(3)
            }
        }
    }
})
