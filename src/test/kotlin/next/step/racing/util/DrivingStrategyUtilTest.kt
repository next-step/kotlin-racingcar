package next.step.racing.util

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class DrivingStrategyUtilTest : DescribeSpec({

    describe("DrivingStrategyUtil method") {
        context("랜덤 알고리즘에 따라 생성된 숫자가 4 이상이면 1이고, 4 미만 0") {
            data class RandomExpected(val algorithm: RandomAlgorithm, val expected: Int)

            withData(
                nameFn = { "when ${it.algorithm()} -> ${it.expected}" },
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
    }
})
