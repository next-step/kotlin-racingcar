package racingcar.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarManagerTest : StringSpec({
    val carManager = CarManager()

    "자동차 생성 테스트" {
        forAll(
            row(listOf("apple", "banana", "kiwi"), 3),
            row(listOf("pizza", "chicken", "rice", "choco", "candy"), 5),
        ) { totalParticipants, expectedSize ->
            val ready = carManager.ready(totalParticipants)
            val actualSize = ready.size
            actualSize shouldBe expectedSize
        }
    }
})
