package com.nextstep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class RacingGameTest {
    @Test
    fun `시도할 횟수가 0보다 작거나 같으면 에러가 발생한다`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            RacingGame("abc", 0)
        }
    }

    @Test
    internal fun `round가 null이면 부적절하다`() {
        val round: Int? = null
        assertThat(RacingGame.isInvalidRound(round)).isTrue()
    }

    @Test
    internal fun `round가 자연수가 아니면 부적절하다`() {
        val round: Int? = -1
        assertThat(RacingGame.isInvalidRound(round)).isTrue()
    }

    @Test
    fun `자동차의 이름의 개수가 0보다 작거나 같으면 에러가 발생한다`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            RacingGame("", 1)
        }
    }
}
