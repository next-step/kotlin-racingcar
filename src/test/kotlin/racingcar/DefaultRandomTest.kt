package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class DefaultRandomTest : StringSpec({
    "랜덤 최소값 = 0" {
        RandomStrategy.minValue shouldBe 0
    }

    "랜덤 최대값 = 9" {
        RandomStrategy.maxValue shouldBe 9
    }
})
