package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.RacingHistory

class RacingHistoryTest : StringSpec({
    "자동차의 움직임이 정확하게 기록되어야 한다" {
        val car = Car("car1")
        val racingHistory = RacingHistory()

        car.move(4)
        racingHistory.record(listOf(car))

        val rounds = racingHistory.getRounds()
        rounds.size shouldBe 1
        rounds.first().first().moveCount shouldBe 1
    }
})
