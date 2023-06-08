package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.util.randomNumber

class RandomGeneratorTest : StringSpec({
    "랜덤 값 생성 범위는 0 ~ 9 " {
        randomNumber() shouldBeInRange 0..9
    }
})
