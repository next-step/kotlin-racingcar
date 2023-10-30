package me.parker.nextstep.kotlinracingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    @Test
    fun `0 ~ 9 사이의 랜덤값 생성`() {
        for (i in 0..100) {
            val randomNumber = RandomNumberGenerator.generate(0, 9)
            assertThat(randomNumber).isBetween(0, 9)
        }
    }
}