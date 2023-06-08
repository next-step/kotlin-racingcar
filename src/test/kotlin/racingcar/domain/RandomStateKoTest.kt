package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomStateKoTest : StringSpec({
    "0-9 사이의 랜덤값 생성" {
        RandomState().randomInt shouldBeInRange 0..9
    }
})
