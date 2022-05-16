package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.utils.RandomNumberGenerator

class RandomNumberGeneratorTest {

    @Test
    fun `랜덤으로 얻어오는 숫자가 정의한 범위 내에 있는지 체크`() {
        Assertions.assertThat(RandomNumberGenerator.getRandomNumber())
            .isGreaterThan(RandomNumberGenerator.RANDOM_NUMBER_START)
            .isLessThan(RandomNumberGenerator.RANDOM_NUMBER_END)
    }
}
