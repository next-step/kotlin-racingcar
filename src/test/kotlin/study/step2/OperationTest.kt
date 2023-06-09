package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

class OperationTest : StringSpec({

    "빈 문자열을 입력하면 에러가 발생 한다." {
        // given
        val expression = ""

        // when & then
        shouldThrow<IllegalArgumentException> { Operation.parse(expression) }
    }

    "공백 문자열을 입력하면 에러가 발생 한다." {
        // given
        val expression = " "

        // when & then
        shouldThrow<IllegalArgumentException> { Operation.parse(expression) }
    }

    "피연산자의 갯수가 연산자의 갯수와 같으면 에러가 발생 한다." {
        // given
        val expression = "2 + 3 -"

        // when & then
        shouldThrow<IllegalArgumentException> { Operation.parse(expression) }
    }

    "연산자의 갯수가 피연산자의 갯수보다 많으면 에러가 발생 한다." {
        // given
        val expression = "2 + -"

        // when & then
        shouldThrow<IllegalArgumentException> { Operation.parse(expression) }
    }

    "피연산자의 갯수가 연산자의 갯수보다 1개 많으면 정상적으로 파싱 된다." {
        // given
        val expression = "2 + 3"

        // when
        val operation = Operation.parse(expression)

        // then
        operation shouldNotBe null
    }

    "피연산자의 갯수가 연산자의 갯수보다 2개 많으면 에러가 발생 한다." {
        // given
        val expression = "2 + 3 4"

        // when & then
        shouldThrow<IllegalArgumentException> { Operation.parse(expression) }
    }

    "연산자와 피연산자의 순서가 올바르지 않을 경우 에러가 발생 한다." {
        // given
        val prefix1 = "+ 2 3"
        val prefix2 = "+ 2 - 3 4"
        val postfix1 = "2 3 +"
        val postfix2 = "2 + 3 5 -"

        // when & then
        shouldThrow<IllegalArgumentException> { Operation.parse(prefix1) }
        shouldThrow<IllegalArgumentException> { Operation.parse(prefix2) }
        shouldThrow<IllegalArgumentException> { Operation.parse(postfix1) }
        shouldThrow<IllegalArgumentException> { Operation.parse(postfix2) }
    }
})
