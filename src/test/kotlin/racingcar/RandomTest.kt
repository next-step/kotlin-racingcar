package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomTest : StringSpec({
    "랜덤 숫자를 생성한다." {
        val random = generate()
        (0..9).contains(random) shouldBe true
    }
})
