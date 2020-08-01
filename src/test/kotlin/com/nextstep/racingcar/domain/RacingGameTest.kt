package com.nextstep.racingcar.domain

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
}
