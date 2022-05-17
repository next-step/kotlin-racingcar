package racing.ui

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class RacingInputViewTest {

    @Test
    fun `The length of car name cannot exceed 5`() {
        //given
        val carNames = "spring,summer,fall,winter"
        val expected = IllegalStateException::class.java

        //when
        assertThatThrownBy { RacingInputView.parseCarNamesStr(carNames) }
            .isInstanceOf(expected) //then
            .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.")
    }

    @Test
    fun `parsing car name string test`() { //given
        val carNameStr = "my,mbti,is,entp"
        val expected = listOf("my", "mbti", "is", "entp")
        assertThat(RacingInputView.parseCarNamesStr(carNameStr)) //when
            .isEqualTo(expected) //then
    }
}
