package study.racing

import org.junit.jupiter.api.Test
import racingcar.Racing
import java.io.BufferedReader
import java.io.InputStreamReader

class RacingTest {

    @Test
    fun racingTest() {
        val racing = Racing()

        racing.startRacing()
    }

    @Test
    fun inputTest() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val inputCarCnt = br.readLine()

        println(inputCarCnt)
    }
}
