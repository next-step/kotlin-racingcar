package me.parker.nextstep.kotlinracingcar.rule

class TestRacingGameMoveRule(private var isForward: Boolean) : RacingGameMoveRule {

    override fun isForward(): Boolean {
        return isForward
    }
}