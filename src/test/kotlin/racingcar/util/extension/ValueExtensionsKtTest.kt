package racingcar.util.extension

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class ValueExtensionsKtTest : BehaviorSpec({
    given("Int 값에 .greaterThanOrEquals 확장함수를 호출 했을 때") {
        val number = 3
        `when`("인자의 값이 더 크다면") {
            then("false 가 반환된다.") {
                listOf(4, 8, 50).forAll {
                    number.greaterThanOrEquals(it) shouldBe false
                }
            }
        }

        `when`("인자의 값이 작거나 같다면") {
            then("true 가 반환된다") {
                listOf(3, 2, 1).forAll {
                    number.greaterThanOrEquals(it) shouldBe true
                }
            }
        }
    }

    given("Int 값에 .isPositive 확장함수를 호출 했을 때") {
        `when`("Int 값이 0 또는 음수라면") {
            then("false 가 반환된다") {
                listOf(0, -1, -100).forAll {
                    it.isPositive() shouldBe false
                }
            }
        }

        `when`("Int 값이 양수라면") {
            then("true 가 반환된다") {
                listOf(5, 100, 77).forAll {
                    it.isPositive() shouldBe true
                }
            }
        }
    }
})
