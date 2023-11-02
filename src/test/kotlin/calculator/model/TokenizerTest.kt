package calculator.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize

class TokenizerTest : StringSpec({

    "한자릿수의 덧셈" {
        val tokens = Tokenizer.toTokens("1+2+4")
        tokens shouldHaveSize 5
        tokens shouldContain "1"
        tokens shouldContain "+"
    }

    "사칙연산" {
        val tokens = Tokenizer.toTokens("1+2+14*333/22")
        tokens shouldHaveSize 9
        tokens shouldContain "14"
        tokens shouldContain "333"
        tokens shouldContain "22"
        tokens shouldContain "/"
        tokens shouldContain "*"
    }

    "화이트스페이스는 동작에 영향을 주지 않는다" {
        val leftWhitespace = Tokenizer.toTokens("1   -2 + 3    / 4")
        leftWhitespace shouldHaveSize 7
        leftWhitespace shouldContain "1"
        leftWhitespace shouldContain "+"
        leftWhitespace shouldContain "2"

        val rightWhitespace = Tokenizer.toTokens("3+     4-   22 * 77")
        rightWhitespace shouldHaveSize 7
        rightWhitespace shouldContain "3"
        rightWhitespace shouldContain "4"
        rightWhitespace shouldContain "77"
        rightWhitespace shouldContain "22"
    }
})
