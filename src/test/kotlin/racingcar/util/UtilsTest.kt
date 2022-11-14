package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UtilsTest {
    @DisplayName("Random 숫자 생성 테스트")
    @Test
    fun `Random 숫자 생성 테스트`() {
        val random = Utils.generateRandomNumber(Utils.RANDOM_NUMBER_START_INDEX, Utils.RANDOM_NUMBER_END_INDEX)
        assertThat(random).isBetween(Utils.RANDOM_NUMBER_START_INDEX, Utils.RANDOM_NUMBER_END_INDEX)
    }

    @DisplayName("Random 숫자 생성 예외처리 테스트")
    @Test
    fun `Random 숫자 생성 예외처리 테스트`() {
        assertThatThrownBy {
            Utils.generateRandomNumber(
                Utils.RANDOM_NUMBER_END_INDEX,
                Utils.RANDOM_NUMBER_START_INDEX
            )
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
