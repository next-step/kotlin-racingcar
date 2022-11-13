package racingcar.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarManagerTest : StringSpec({
    val carManager = CarManager()

    "자동차 생성 테스트" {
        forAll(
            row(3, 3),
            row(3, 3),
            row(5, 5),
        ) { totalParticipants, expectedSize ->
            val ready = carManager.ready(totalParticipants)
            val actualSize = ready.size
            actualSize shouldBe expectedSize
        }
    }
})
