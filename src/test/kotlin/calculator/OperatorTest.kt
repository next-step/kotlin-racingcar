package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({
    given("getOperator에서") {
        `when`("사칙연산이 아닌 문자가 연산자 들어오면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> {
                    Operator.getOperator("")
                }
            }
        }

        forAll(
            table(
                headers("input", "expected operator"),
                row("+", Operator.PLUS),
                row("-", Operator.MINUS),
                row("*", Operator.MUL),
                row("/", Operator.DIV)
            )
        ) { input: String, operator: Operator ->
            `when`("${input}이(가) 들어오면") {
                then("${operator}이(가) 반환된다") {
                    Operator.getOperator(input) shouldBe operator
                }
            }
        }
    }

    given("PLUS에서") {
        `when`("숫자가 두개 들어올때") {
            then("두 숫자의 합이 반환된다") {
                Operator.PLUS(1, 2) shouldBe 3
            }
        }
    }

    given("MINUS에서") {
        `when`("숫자가 두개 들어올때") {
            then("두 숫자의 차가 반환된다") {
                Operator.MINUS(1, 2) shouldBe -1
            }
        }
    }

    given("MUL에서") {
        `when`("숫자가 두개 들어올때") {
            then("두 숫자의 곱이 반환된다") {
                Operator.MUL(2, 3) shouldBe 6
            }
        }
    }

    given("DIV에서") {
        `when`("0으로 나눌때") {
            then("예외가 던져진다") {
                shouldThrow<ArithmeticException> {
                    Operator.DIV(6, 0)
                }
            }
        }

        `when`("숫자가 두개 들어올때") {
            then("두 숫자의 나눈 몫이 반환된다") {
                Operator.DIV(6, 2) shouldBe 3
            }
        }
    }
})
