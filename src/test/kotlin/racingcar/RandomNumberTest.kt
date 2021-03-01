package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.RandomNumber

class RandomNumberTest {

    private val randomNumber = RandomNumber()

    @Test
    fun `랜덤숫자 범위일때`() {
        assertThat(randomNumber.generateRandomNumber()).isBetween(0, 9)
    }
}
