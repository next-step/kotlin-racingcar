package racingcar.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn

class RandomGeneratorTest : FunSpec({
    context("랜덤 값은 0이상, 지정한 값 이하여야 한다.") {
        val threshold = 10
        val randomIntNumbers = RandomGenerator.getRandomIntNumber(threshold)
        randomIntNumbers shouldBeIn (0..threshold).toList().toTypedArray()
    }
})
