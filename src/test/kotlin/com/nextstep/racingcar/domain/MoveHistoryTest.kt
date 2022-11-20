package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoveHistoryTest : StringSpec({
    "MoveHistory can give user's location" {
        val moveHistory = MoveHistory()
        moveHistory.saveHistory(MOVE)
        moveHistory.saveHistory(NONE)
        moveHistory.saveHistory(MOVE)
        moveHistory.saveHistory(MOVE)

        val location = moveHistory.getLocation()

        location shouldBe 3
    }
})
