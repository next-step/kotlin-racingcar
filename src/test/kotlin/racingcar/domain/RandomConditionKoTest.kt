package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomConditionKoTest : StringSpec({
    "0-9 사이의 랜덤값 생성" {
        RandomCondition().randomInt shouldBeInRange 0..9
    }
})
