package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.domain.NumberGenerator
import kotlin.random.Random

class RandomGeneratorTest : StringSpec({
    val randomNumberGenerator = NumberGenerator { Random.nextInt(0, 10) }
    "랜덤 값 생성 범위는 0 ~ 9 " {
        randomNumberGenerator.generateNumber() shouldBeInRange 0..9
    }
})
