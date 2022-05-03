package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class StringTest : StringSpec({

    "isEmpty" {
        println("".isEmpty())
    }

    "isBlank" {
        " ".isBlank().shouldBeTrue()
        "\r\n".isBlank().shouldBeTrue()
        "\t".isBlank().shouldBeTrue()
    }

    "string" {
        "Int"[0] shouldBe 'I'
        "Int"[1] shouldBe 'n'
        "Int"[2] shouldBe 't'
    }
})
