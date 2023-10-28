package racing.model.generator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeInRange

class RandomGeneratorTest : StringSpec({

    "1에서 9 사이에서 무작위 값이 출력되어야한다" {
        val generator = RandomGenerator()
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
    }

    "1에서 9 까지의 모든 숫자가 나와야한다" {
        val generator = RandomGenerator()
        val acutal: Set<Int> = (1..100)
            .map { generator.generate() }
            .toList()
            .toSet()
        acutal shouldContain 1
        acutal shouldContain 2
        acutal shouldContain 3
        acutal shouldContain 4
        acutal shouldContain 5
        acutal shouldContain 6
        acutal shouldContain 7
        acutal shouldContain 8
        acutal shouldContain 9
        println("0.00000766915 확률로 실패함, (8/9)^100 * 9가지 숫자")
    }
})
