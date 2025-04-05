package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.Name
import java.util.stream.Stream

class WinnersTest {
    @MethodSource("provideCarsAndWinners")
    @ParameterizedTest
    fun `Return correct winners from given cars`(
        cars: List<Car>,
        expectedWinners: List<Car>,
    ) {
        // given && when
        val actual = Winners.of(cars)

        // then
        assertThat(actual.cars).hasSameElementsAs(expectedWinners)
    }

    companion object {
        @JvmStatic
        fun provideCarsAndWinners(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(Car(Name("car1"), 1), Car(Name("car2"), 1)),
                    listOf(Car(Name("car1"), 1), Car(Name("car2"), 1)),
                ),
                Arguments.of(
                    listOf(Car(Name("car1"), 1), Car(Name("car2"), 0)),
                    listOf(Car(Name("car1"), 1)),
                ),
            )
        }
    }
}
