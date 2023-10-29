package game

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarNameValidatorTest {

    @ParameterizedTest
    @MethodSource("provideLongCarNames")
    fun `자동차 이름이 하나라도 5자를 넘으면 예외를 던진다`(carNames: List<String>) {
        assertThatThrownBy { CarNameValidator.validate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("자동차 이름은 5자를 넘을 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource("provideRightCarNames")
    fun `자동차 이름이 모두 5자 이하면 예외를 던지지 않는다`(carNames: List<String>) {
        CarNameValidator.validate(carNames)
    }

    companion object {
        @JvmStatic
        fun provideLongCarNames(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("apple", "banana")),
                Arguments.of(listOf("longna", "apple", "carrot")),
            )
        }

        @JvmStatic
        fun provideRightCarNames(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("pobi", "crong", "honux")),
                Arguments.of(listOf("a", "b", "c", "d")),
                Arguments.of(listOf("14", "15", "16", "17")),
            )
        }
    }
}
