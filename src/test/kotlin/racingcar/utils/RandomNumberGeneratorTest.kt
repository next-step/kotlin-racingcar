package racingcar.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange

internal class RandomNumberGeneratorTest : FunSpec({
    context("랜덤값을 생성할 수 있다.") {
        RandomNumberGenerator.generate(0..9) shouldBeInRange (0..9)
    }
})
