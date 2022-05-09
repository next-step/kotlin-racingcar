package step3.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import step3.racingcar.RandomNumberGenerator

class NumberGenerateTest {

    @RepeatedTest(100)
    fun `0-9 사이 임의의 정수를 생성한다`() {
        val testRange = 1..9
        val testList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        assertThat(RandomNumberGenerator.generate()).isIn(testRange)
        assertThat(RandomNumberGenerator.generate()).isIn(testList)
    }
}
