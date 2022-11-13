package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RandomForwardTest : StringSpec({
    "랜덤 최소값 = 0" {
        RandomForward.minValue shouldBe 0
    }

    "랜덤 최대값 = 9" {
        RandomForward.maxValue shouldBe 9
    }
})
