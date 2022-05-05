package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class OneSpaceSeparationStrategyTest : StringSpec({

    "하나의 문자열을 받아 여러 개의 문자열로 분리할 수 있다 (기준: 스페이스 하나)" {
        val separationStrategy: SeparationStrategy = OneSpaceSeparationStrategy()

        listOf(
            "abc" to listOf("abc"),
            "abc def" to listOf("abc", "def"),
            "ab cd e f" to listOf("ab", "cd", "e", "f"),
            "a b c d e f" to listOf("a", "b", "c", "d", "e", "f"),
        ).forAll { (text, expected) ->
            val actual = separationStrategy.separate(text)
            actual shouldBe expected
        }
    }
})
