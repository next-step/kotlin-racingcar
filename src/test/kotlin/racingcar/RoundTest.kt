package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RoundTest : ShouldSpec({
    context("Create") {
        should("create round") {
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forAll {
                shouldNotThrowAny {
                    Round(it)
                }
            }
        }

        should("throw exception if round is below 1 or over 10") {
            listOf(-1, 0).forAll {
                shouldThrow<IllegalArgumentException> {
                    Round(it)
                }
            }
        }
    }

    context("CanContinue") {
        should("return true if round value is above 1") {
            listOf(1, 2, 3, 8, 9, 10).forAll {
                Round(it).canContinue shouldBe true
            }
        }

        should("return false if round value is 0 or below") {
            val round = Round(1)
            round.proceed()

            round.canContinue shouldBe false
        }
    }

    context("Proceed") {
        should("deduct round if the value is above 0") {
            val round = Round(1)
            round.proceed()

            round.canContinue shouldBe false
        }

        should("throw exception if there is no round to proceed.") {
            val round = Round(1)
            round.proceed()

            shouldThrow<IllegalStateException> {
                round.proceed()
            }
        }
    }
})
