package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

internal class RandomCountGeneratorTest : StringSpec({
    "랜덤하게 9 보다 작거나 같은 카운트를 생성한다" {
        val count = RandomCountGenerator.generateCount()
        count shouldBeLessThanOrEqual 9
    }
    "랜덤하게 0 보다 크거나 같은 카운트를 생성한다" {
        val count = RandomCountGenerator.generateCount()
        count shouldBeGreaterThanOrEqual 0
    }
})
