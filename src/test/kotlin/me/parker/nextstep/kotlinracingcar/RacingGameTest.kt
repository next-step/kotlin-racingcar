package me.parker.nextstep.kotlinracingcar

import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `0 ~ 9 사이 랜덤값을 반환 - 100번 반복`() {
        val racingGame = RacingGame()

        for (i in 1..100) {
            val randomNumber = racingGame.getRandomNumber()
            println("randomNumber = $randomNumber")

            assert(randomNumber in 0..9)
        }
    }
}