package me.parker.nextstep.kotlinracingcar.rule

class RandomRacingGameMoveRule : RacingGameMoveRule {
    companion object {
        private const val FORWARD_STANDARD = 4
    }

    override fun isForward(): Boolean {
        return (Math.random() * 10).toInt() >= FORWARD_STANDARD
    }
}