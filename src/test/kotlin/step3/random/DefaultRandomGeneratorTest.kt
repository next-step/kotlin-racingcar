package step3.random

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn
import step3.domain.game.random.DefaultRandomGenerator

class DefaultRandomGeneratorTest : FunSpec({
    val randomGenerator = DefaultRandomGenerator

    test("should generate random containing candidates") {
        repeat(randomGenerator.candidates.size * 3) {
            randomGenerator.random() shouldBeIn randomGenerator.candidates
        }
    }
})
