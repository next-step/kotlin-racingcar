package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoveHistoryTest : StringSpec({
    "MoveHistory can give user's location" {
        val histories = mutableListOf(MOVE, MOVE, MOVE, NONE)
        val moveHistory = MoveHistory(histories)

        val location = moveHistory.getLocation()

        location shouldBe 3
    }
})
