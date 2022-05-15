package step3.util

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomGeneratorTest : FunSpec({

    test("generate") {
        val minValue = 0
        val maxValue = 9
        for (i in 1..1000) {
            val randomValue = RandomGenerator.generate(minValue, maxValue)
            randomValue shouldBeInRange (minValue..maxValue)
        }
    }
})
