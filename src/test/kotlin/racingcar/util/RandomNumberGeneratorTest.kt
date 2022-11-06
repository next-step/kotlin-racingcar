package racingcar.util

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.property.checkAll

internal class RandomNumberGeneratorTest : FunSpec({
    context("랜덤한 값은 항상 0~9 사이로 이루어져있다.") {
        checkAll<Int, Int> (10) { a, b ->
            RandomNumberGenerator.generate(a..b) shouldBeInRange 0..9
        }
    }
})
