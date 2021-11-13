package racingcar.domain.engine

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("전진 여부를 주입할 수 있는 객체인 CustomEngine 테스트")
internal class CustomEngineTest {
    @DisplayName("주어진 실린더 값의 범위가 `0 ~ 9` 라면 생성한 `CustomEngine`의 실린더 값과 기준 값이 동일")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun isSameCylinderIfGivenCylinderBetweenOneAndZero(
        givenCylinder: Int
    ) {
        // Arrange
        val engine: Engine = CustomEngine(givenCylinder)

        // Act
        val resultCylinder = engine.cylinder()

        // Assert
        assertThat(resultCylinder).isEqualTo(givenCylinder)
    }

    @DisplayName("주어진 기준 값이 값의 범위가 `0 ~ 9` 아니라면 CustomEngine 생성 시 실패")
    @ParameterizedTest
    @MethodSource("cylindersThatIsNotBetweenOneAndZero")
    fun createCustomEngineIsFailIfGivenCylinderNotBetweenOneAndZero(
        givenCylinder: Int,
        expectedException: Exception,
        containErrorMessage: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            CustomEngine(givenCylinder)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessage)
    }

    companion object {
        private const val illegalArgumentErrorMessage = "Failed requirement"
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun cylindersThatIsNotBetweenOneAndZero(): Stream<Arguments> =
            Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-123_456, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_109_784, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(10, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(839_187, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(100_000_000, illegalArgumentException, illegalArgumentErrorMessage),
            )
    }
}
