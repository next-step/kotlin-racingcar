package random

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeIn

internal class RandomNumberGeneratorTest : StringSpec({
    "주어진 수 사이에 있는 임의의 정수를 반환한다" {
        val from = 1
        val to = 10

        val result = List(1000) { RandomNumberGenerator.generate(from, to) }

        result.forAll { it shouldBeIn (1..10).toList() }
    }
})
