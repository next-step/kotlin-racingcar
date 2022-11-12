package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RoundsTest : StringSpec() {
    init {
        "Rounds 는 다음 라운드가 있는지 확인할 수 있다" {
            val rounds = Rounds(1)

            rounds.hasNext() shouldBe true
        }

        "play 를 하면 Rounds 가 진행된다" {
            val rounds = Rounds(1)

            rounds.play()

            rounds.hasNext() shouldBe false
        }
    }
}
