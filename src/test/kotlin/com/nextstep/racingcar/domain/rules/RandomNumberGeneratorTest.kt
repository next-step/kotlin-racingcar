package com.nextstep.racingcar.domain.rules

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class RandomNumberGeneratorTest : StringSpec({

    "RandomNumberGenerator always generate number only between 0 and 9" {
        val randomNumberGenerator = RandomNumberGenerator()

        val generatedNumber = randomNumberGenerator.generate()
        generatedNumber shouldBeGreaterThanOrEqual 0
        generatedNumber shouldBeLessThanOrEqual 9
    }
})
