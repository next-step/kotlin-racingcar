package racing.ui

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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

    @ParameterizedTest
    @MethodSource("generateData")
    fun `parsing car name string test`(carNameStr: String, expected: List<String>) { //given
        assertThat(RacingInputView.parseCarNamesStr(carNameStr)) //when
            .isEqualTo(expected) //then
    }

    companion object {
        @JvmStatic
        private fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "my,mbti,is,entp",
                    listOf("my", "mbti", "is", "entp")
                ),
                Arguments.of(
                    "I,my,me,mine",
                    listOf("I", "my", "me", "mine")
                ),
                Arguments.of(
                    "you,your,yours",
                    listOf("you", "your", "yours")
                ),
            )
        }
    }
}