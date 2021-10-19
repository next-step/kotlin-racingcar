package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.DriveRule

class DriveRuleTest {
    @Test
    @DisplayName("랜덤값 범위 테스트")
    fun `check DriveRule`() {
        val randomInt = DriveRule().random()
        Assertions.assertThat(randomInt).isNotNull
        Assertions.assertThat(randomInt).isLessThanOrEqualTo(9)
        Assertions.assertThat(randomInt).isGreaterThanOrEqualTo(0)
    }

    @Test
    @DisplayName("전진하는 기준 값 테스트")
    fun `check value of forward standard`() {
        Assertions.assertThat(DriveRule.FORWARD_NUMBER).isEqualTo(4)
    }
}
