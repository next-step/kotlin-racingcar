package racing.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class RoundHistoryTest : StringSpec({

    "자동차 이름은 중복되선 안된다, 중복시 exception throw" {
        val results = ArrayDeque(
            listOf(
                Car("Honux", 1),
                Car("Honux", 2)
            )
        )
        shouldThrow<IllegalArgumentException> {
            RoundHistory(results)
        }
    }
})
