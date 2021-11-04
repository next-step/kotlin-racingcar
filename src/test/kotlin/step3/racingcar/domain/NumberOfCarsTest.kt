package step3.racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import step3.racingcar.domain.cars.NumberOfCars
import java.util.stream.Stream

@DisplayName("Cars 객체의 자동차 수를 담당하는 객체인 NumberOfCars 테스트")
internal class NumberOfCarsTest {
    @DisplayName("주어진 자동차 수가 올바른 경우 NumberOfCar 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 189, 100_000, 200_442, 32_092_122, 1_000_000_000])
    fun given_CorrectNumberOfCars_when_CreateNumberOfCars_then_Success(givenNumberOfCars: Int) {
        // Arrange
        // Act
        val numberOfCars = NumberOfCars(givenNumberOfCars)

        // Assert
        assertThat(numberOfCars.value).isEqualTo(givenNumberOfCars)
    }

    @DisplayName("주어진 자동차 수가 올바르지 않은 경우 NumberOfCar 객체 생성 실패")
    @ParameterizedTest
    @MethodSource("inCorrectNumberOfCarsValues")
    fun given_inCorrectNumberOfCars_when_CreateNumberOfCars_then_Success(
        givenNumberOfCars: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            NumberOfCars(givenNumberOfCars)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()
        private const val illegalArgumentErrorMessage = "Failed requirement"

        @JvmStatic
        fun inCorrectNumberOfCarsValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-231, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-191_297, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_191_089, illegalArgumentException, illegalArgumentErrorMessage)
            )
        }
    }
}
