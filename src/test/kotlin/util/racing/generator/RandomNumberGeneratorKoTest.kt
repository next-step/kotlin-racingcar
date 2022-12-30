package util.racing.generator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomNumberGeneratorKoTest : DescribeSpec({
    describe("method test") {
        context("generate test") {
            it("0부터 9사이의 값이 나온다.") {
                val numberGenerator: NumberGenerator = RandomNumberGenerator()

                numberGenerator.generate() shouldBeInRange 0..9
            }
        }
    }
})
