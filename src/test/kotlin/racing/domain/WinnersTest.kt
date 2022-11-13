package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class WinnersTest : StringSpec() {
    init {
        "Winners 는 승리자를 찾을 수 있다" {
            val lastRoundResult = CarInfos(listOf(
                CarInfo("kim", Position(1)),
                CarInfo("ko", Position(3)),
                CarInfo("rong", Position(2)),
                CarInfo("i", Position(3)))
            )
            val winners = Winners(lastRoundResult)

            winners.winners shouldContainExactly listOf(
                CarInfo("ko", Position(3)),
                CarInfo("i", Position(3))
            )
        }
    }

}
