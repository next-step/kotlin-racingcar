package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import kotlin.reflect.KClass

class CalculatorTest : BehaviorSpec({
    val target = Calculator()

    given("SplitExpression메소드에서") {
        `when`("NULL이 들어올때") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { target.splitExpression(null) }
            }
        }

        `when`("공백이 들어올때") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { target.splitExpression(" ") }
            }
        }

        `when`("항의 개수가 짝수인 식이 들어오면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { target.splitExpression("1 + 2  * 3 / ") }
            }
        }

        `when`("식이 들어오면") {
            then("분할된다") {
                target.splitExpression("1 + 2 * 3 / 4") shouldBe
                    listOf("1", "+", "2", "*", "3", "/", "4")
            }
        }
    }

    given("parseExpression메소드에서") {
        `when`("연산자에 유효하지 않은 값이 들어오면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { target.parseExpression(listOf("1", "!", "2")) }
            }
        }

        `when`("피연산자에 유효하지 않은 값이 들어오면") {
            then("예외가 던져진다") {
                shouldThrow<NumberFormatException> { target.parseExpression(listOf("1", "+", "!")) }
            }
        }

        `when`("분할된 식이 들어오면") {
            then("연산자와 피연산자 리스트를 반환한다") {
                target.parseExpression(listOf("1", "+", "2")) shouldBe Pair(listOf(Operator.PLUS), listOf(2L))
            }
        }
    }

    given("calculateExpression메소드에서") {
        forAll(
            table(
                headers("expression", "expected exception"),
                row(" ", IllegalArgumentException::class),
                row("1 + ", IllegalArgumentException::class),
                row("1 ! 2", IllegalArgumentException::class),
                row("1 + !", NumberFormatException::class)
            )
        ) { expression: String, expectedException: KClass<out Throwable> ->
            `when`("`$expression`라는 식이 들어오면") {
                then("예외가 던져진다") {
                    val exception = shouldThrow<Throwable> { target.calculateExpression(expression) }
                    exception::class shouldBe expectedException
                }
            }
        }

        forAll(
            table(
                headers("expression", "expected result"),
                row("1", 1L),
                row("1 + 2", 3L),
                row("1 + 2 * 3", 9L),
                row("1 + 2 * 3 / 4 ", 2L)
            )
        ) { expression: String, result: Long ->
            `when`("`$expression`라는 식이 들어오면") {
                then("${result}를 반환한다") {
                    target.calculateExpression(expression) shouldBe result
                }
            }
        }
    }
})
