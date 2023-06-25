package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import kotlin.random.Random

class RandomGeneratorTest : StringSpec({
    "랜덤 값 생성 범위는 0 ~ 9 " {
        Random.nextInt(0, 10) shouldBeInRange 0..9
    }
})
