package racing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class RacingTest : StringSpec({

    "사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다" {
        val actual1 = Racing().race(1, 1)
        actual1[0].result shouldHaveSize 1
        actual1 shouldHaveSize 1

        val actual2 = Racing().race(3, 5)
        actual2[0].result shouldHaveSize 3
        actual2[2].result shouldHaveSize 3
        actual2 shouldHaveSize 5

        val actual3 = Racing().race(7, 17)
        actual3[0].result shouldHaveSize 7
        actual3[4].result shouldHaveSize 7
        actual3[16].result shouldHaveSize 7
        actual3 shouldHaveSize 17
    }
})
