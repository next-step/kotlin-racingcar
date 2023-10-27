package racing.model.generator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomGeneratorTest : StringSpec({
    "에서 9 사이에서 무작위 값이 출력되어야한다" {
        val generator = RandomGenerator()
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
        generator.generate() shouldBeInRange IntRange(1, 9)
    }
})
