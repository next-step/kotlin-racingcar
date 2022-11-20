package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SettingTest {

    @Test
    fun `numberOfLab 을 기본 인자 5로 생성된다`() {
        assertThat(Setting.byCarNames(listOf("더미", "이름"))).isEqualTo(Setting.byCarNames(listOf("더미", "이름"), 5))
    }

    @Test
    fun `numberOfLab 1보다 작은 수는 입력할 수 없다`() {
        val numberOfLab = 0

        val assertion = assertThrows<IllegalArgumentException> {
            Setting.byCarNames(listOf("더미", "이름"), numberOfLab)
        }

        assertThat(assertion.message).isEqualTo("1보다 작은 정수를 입력할 수 없습니다")
    }

    @Test
    fun `numberOfLab 1보다 큰 수를 넣으면 생성된다`() {
        val numberOfLab = 3
        assertThat(Setting.byCarNames(listOf("더미", "이름"), numberOfLab)).isEqualTo(
            Setting.byCarNames(
                listOf("더미", "이름"),
                3
            )
        )
    }

    @Test
    fun `빈 이름 배열은 입력할 수 없다`() {
        val assertion = assertThrows<IllegalArgumentException> {
            Setting(emptyList())
        }

        assertThat(assertion.message).isEqualTo("자동차 이름이 최소한 하나는 있어야합니다")
    }
}
