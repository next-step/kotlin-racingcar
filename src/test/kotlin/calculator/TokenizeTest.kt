package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class TokenizeTest : StringSpec({
    "null 을 제공하면 에러가 발생한다" {
        // given
        val input = null

        // when
        val exception = shouldThrow<IllegalArgumentException> {
            tokenize(input)
        }

        // then
        exception.message shouldBe "잘못된 입력입니다: null"
    }

    "빈 문자열을 제공하면 에러가 발생한다" {
        // given
        val input = ""

        // when
        val exception = shouldThrow<IllegalArgumentException> {
            tokenize(input)
        }

        // then
        exception.message shouldBe "잘못된 입력입니다: "
    }

    "공백 문자열을 제공하면 에러가 발생한다" {
        // given
        val input = " \r\n\t"

        // when
        val exception = shouldThrow<IllegalArgumentException> {
            tokenize(input)
        }

        // when
        exception.message shouldContain "잘못된 입력입니다: "
    }

    "유효하지 않은 입력을 제공하면 에러가 발생한다" {
        // given
        val input = "3 + foo - 0"

        // when
        val exception = shouldThrow<IllegalArgumentException> {
            tokenize(input)
        }

        // when
        exception.message shouldBe "유효하지 않은 문자열입니다: foo"
    }

    "주어진 문자열을 token 리스트로 변환한다" {
        // given
        val input = "  2 + 3 * 4  / 2 - 10  "

        // when
        val tokens = tokenize(input)

        // when
        tokens shouldBe listOf(
            Token.Number(2),
            Token.Plus,
            Token.Number(3),
            Token.Asterisk,
            Token.Number(4),
            Token.Slash,
            Token.Number(2),
            Token.Minus,
            Token.Number(10),
        )
    }
})
