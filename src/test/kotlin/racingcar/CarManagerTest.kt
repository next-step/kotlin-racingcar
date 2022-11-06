package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarManagerTest : StringSpec({
    val carManager = CarManager()

    "자동차 생성 테스트" {
        listOf(
            1 to 1,
            100 to 100,
            0 to 0,
            -1 to 0
        ).forEach { (input, expected) ->
            val actual = carManager.ready(input)
            actual.size shouldBe expected
        }
    }
})
