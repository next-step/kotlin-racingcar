package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OneSpaceSeparationStrategyTest : StringSpec({

    "하나의 문자열을 받아 여러 개의 문자열로 분리할 수 있다 (기준: 스페이스 하나)" {
        val separationStrategy: SeparationStrategy = OneSpaceSeparationStrategy()
        val parameters = listOf(
            OneSpaceExpressionFixture("abc", listOf("abc")),
            OneSpaceExpressionFixture("abc def", listOf("abc", "def")),
            OneSpaceExpressionFixture("ab cd e f", listOf("ab", "cd", "e", "f")),
            OneSpaceExpressionFixture("a b c d e f", listOf("a", "b", "c", "d", "e", "f")),
        )

        parameters.forEach {
            val actual = separationStrategy.separate(it.text)
            actual shouldBe it.separations
        }
    }
})
