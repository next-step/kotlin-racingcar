package racing.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions

class GameCountTest : StringSpec({

    "경기 횟수 감소" {
        val gameCount = GameCount(5)
        val downCounted = gameCount.downCount()
        Assertions.assertThat(downCounted).isEqualTo(GameCount(4))
    }

    "경기 횟수 잔여 여부확인" {
        val gameCount = GameCount(1)
        val downCounted = gameCount.downCount()
        Assertions.assertThat(downCounted.isLeft).isFalse()
    }
})
