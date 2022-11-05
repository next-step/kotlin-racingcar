package calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class ExpressionTest : FunSpec({
    context("올바른 데이터는 검증에 성공한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("2", "+", "2"),
                listOf("4", "/", "2", "+", "1")
            )
        ) { data ->
            shouldNotThrowAny {
                Expression(data)
            }
        }
    }

    context("올바르지 않은 데이터는 검증에 실패한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("2", "+"),
                listOf("2", "+", "2", "-"),
                listOf("+", "+", "2")
            )
        ) { data ->
            shouldThrow<IllegalArgumentException> {
                Expression(data)
            }
        }
    }

    context("올바른 데이터의 계산을 진행한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("2", "+", "2") to 4.0,
                listOf("4", "/", "2", "+", "1") to 3.0,
                listOf("5", "*", "4", "/", "4") to 5.0
            )
        ) { (data, result) ->
            Expression(data).calculate() shouldBe result
        }
    }
})
