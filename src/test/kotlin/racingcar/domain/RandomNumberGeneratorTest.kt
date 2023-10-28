package racingcar.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class RandomNumberGeneratorTest : ExpectSpec({
    expect("0에서 9사이의 숫자가 생성된다") {
        val result = RandomNumberGeneratorInBound().getNumber()

        result.shouldBeGreaterThanOrEqual(0)
        result.shouldBeLessThanOrEqual(9)
    }
})
