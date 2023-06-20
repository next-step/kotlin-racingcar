package racingcar.numbergenerator

import io.kotest.matchers.ints.shouldBeBetween
import org.junit.jupiter.api.RepeatedTest

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    fun `0부터 9까지의 숫자를 반환한다`() {
        val randomNumberGenerator = RandomNumberGenerator()
        randomNumberGenerator.get().shouldBeBetween(0, 9)
    }
}
