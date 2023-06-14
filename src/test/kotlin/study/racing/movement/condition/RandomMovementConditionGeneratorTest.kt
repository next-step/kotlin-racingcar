package study.racing.movement.condition

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual

internal class RandomMovementConditionGeneratorTest : StringSpec({
    "랜덤하게 생성된 0 에서 10 사이의 정수를 반환한다" {
        val sut = RandomMovementConditionGenerator()
        val actual = sut.execute()
        actual shouldBeGreaterThanOrEqual (0)
        actual shouldBeLessThan (10)
    }
})
