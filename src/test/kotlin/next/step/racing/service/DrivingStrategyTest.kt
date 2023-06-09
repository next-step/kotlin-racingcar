package next.step.racing.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class DrivingStrategyTest : FunSpec({
    context("random") {
        data class RandomExpected(val algorithm: () -> Int, val expected: Int)
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
            DrivingStrategy.random(algorithm)() shouldBe expected
        }
    }
})
