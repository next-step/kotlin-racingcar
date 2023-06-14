package racingcar.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import racingcar.domain.condition.Condition

class RacingGameServiceTest : StringSpec({
    val racingGameService = RacingGameService()

    "게임 진행 할 때, 올바른 우승자가 반환된다." {
        racingGameService.initCars(
            listOf("gray", "jenny", "gold"),
            object : Condition {
                override fun canMove(): Boolean = true
            }
        )
        racingGameService.play()
        val winners = racingGameService.getWinners()
        val winnerCarNames = winners.map { it.carName.name }
        listOf("gray", "jenny", "gold") shouldContainExactly winnerCarNames
    }
})
