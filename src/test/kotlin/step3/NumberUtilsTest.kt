package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step3.utils.NumberUtils

class NumberUtilsTest {

    @Test
    fun `랜덤으로 얻어오는 숫자가 정의한 범위 내에 있는지 체크`() {
        Assertions.assertThat(NumberUtils.getRandomNumber())
            .isGreaterThan(NumberUtils.RANDOM_NUMBER_START)
            .isLessThan(NumberUtils.RANDOM_NUMBER_END)
    }
}
