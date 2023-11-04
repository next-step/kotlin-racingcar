package me.parker.nextstep.kotlinracingcar.domain.rule

import me.parker.nextstep.kotlinracingcar.domain.rule.RacingGameMoveRule

class TestRacingGameMoveRule(private var isForward: Boolean) : RacingGameMoveRule {

    override fun isForward(): Boolean {
        return isForward
    }
}