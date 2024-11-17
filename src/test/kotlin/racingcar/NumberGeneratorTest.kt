package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberGeneratorTest : StringSpec({
    "generate 함수는 의도한 숫자를 반환한다" {
        val numberGenerator: NumberGenerator = FixedNumberGenerator(4)
        numberGenerator.generate() shouldBe 4
    }
})
