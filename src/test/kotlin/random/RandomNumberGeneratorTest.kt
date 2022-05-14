package random

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll

internal class RandomNumberGeneratorTest : StringSpec({
    "주어진 수 사이에 있는 임의의 정수를 반환한다" {
        val from = 1
        val to = 10

        val generator = List(1000) { RandomNumberGenerator.generate(from, to) }

        generator shouldContainAll (1..10).toList()
    }
})
