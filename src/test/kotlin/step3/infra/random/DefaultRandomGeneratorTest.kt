package step3.infra.random

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn

class DefaultRandomGeneratorTest : FunSpec({
    val randomGenerator: RandomGenerator<Int> = DefaultRandomGenerator

    test("should generate random containing candidates") {
        repeat(randomGenerator.candidates.size * 3) {
            randomGenerator.random() shouldBeIn randomGenerator.candidates
        }
    }
})
