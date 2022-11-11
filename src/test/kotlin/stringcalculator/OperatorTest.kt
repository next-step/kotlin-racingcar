package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class OperatorTest : StringSpec({
    "지원하는 연산자 키워드를 입력하면 연산자 객체를 반환한다" {
        listOf("+", "-", "*", "/").forAll {
            Operator.find(it).shouldBeInstanceOf<Operator>()
        }
    }

    "지원하지 않는 연산자 키워드를 입력하면 예외가 발생한다" {
        shouldThrowExactly<IllegalArgumentException> { Operator.find("%") }
    }

    "주어진 입력에 대해 올바른 결과를 반환한다" {
        forAll(
            row(1.0, Operator.PLUS, 2.0, 3),
            row(1.0, Operator.MINUS, 2.0, -1),
            row(1.0, Operator.DIVIDE, 2.0, 0.5),
            row(1.0, Operator.MULTIPLY, 2.0, 2)
        ) { first, operator, second, result ->
            operator(first, second) shouldBe result
        }
    }
})
