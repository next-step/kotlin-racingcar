package me.parker.nextstep.kotlinracingcar.rule

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameMoveRuleTest {

    @Test
    fun `게임 룰에서 앞으로 갈 수 있으면 true 반환`() {
        val goForwardRule = TestRacingGameMoveRule(true)

        val isForward = goForwardRule.isForward()

        assertThat(isForward).isTrue()
    }

    @Test
    fun `게임 룰에서 앞으로 갈 수 없으면 false 반환`() {
        val stopRule = TestRacingGameMoveRule(false)

        val isForward = stopRule.isForward()

        assertThat(isForward).isFalse()
    }
}