package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.RepeatedTest
import racing.domain.RandomGenerator

class RandomGeneratorTest {

    @RepeatedTest(value = 5)
    fun `랜덤숫자 발행 테스트`() {
        for (i in 1..9) {
            val randomNumber = RandomGenerator.generate()
            assertThat(randomNumber).isGreaterThanOrEqualTo(0)
            assertThat(randomNumber).isLessThanOrEqualTo(9)
        }
    }
}
