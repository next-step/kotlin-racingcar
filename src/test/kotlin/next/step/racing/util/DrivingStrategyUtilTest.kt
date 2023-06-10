package next.step.racing.util

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class DrivingStrategyUtilTest : FunSpec({
    context("random") {
        data class RandomExpected(val algorithm: RandomAlgorithm, val expected: Int)
        withData(
            RandomExpected({ 0 }, 0),
            RandomExpected({ 1 }, 0),
            RandomExpected({ 2 }, 0),
            RandomExpected({ 3 }, 0),
            RandomExpected({ 4 }, 1),
            RandomExpected({ 5 }, 1),
            RandomExpected({ 6 }, 1),
            RandomExpected({ 7 }, 1),
            RandomExpected({ 8 }, 1),
            RandomExpected({ 9 }, 1),
        ) { (algorithm, expected) ->
            DrivingStrategyUtil.random(algorithm)() shouldBe expected
        }
    }
})
