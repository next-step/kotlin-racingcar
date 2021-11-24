package racingcar.domain.cars

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("`RacingCar` 객체의 복수 형태 객체인 `RacingCars` 테스트")
internal class RacingCarsTest {
    @DisplayName("빈 리스트가 주어지면 `RacingCars` 생성 시 실패")
    @ParameterizedTest
    @MethodSource("racingCarList")
    fun createRacingCarsIsFailIfGiven() {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy {
            val racingCars = RacingCars(racingCarList = listOf())
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Failed requirement")
    }

    @DisplayName("차 리스트가 주어지면 `RacingCars` 생성 시 성공")
    @ParameterizedTest
    @MethodSource("racingCarList")
    fun createRacingCarsIsSuccessIfGivenRacingCarList(racingCarList: List<RacingCar>) {
        // Arrange
        // Act
        val racingCars = RacingCars(racingCarList = racingCarList)

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(racingCarList.size)
        assertThat(racingCars.currentRacingDistances.size).isEqualTo(racingCarList.size)
        assertThat(racingCars.currentRacingDistances[0]).isEqualTo(0)
    }

    @DisplayName("`RacingCars` 객체가 올바르게 생성되고 실린더가 4개 이상인 `CustomEngine`이 주어지면 모든 차들이 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("racingCarListAndCustomEngineWhatCylinderIsGreaterThanThree")
    fun carsRaceAreSuccessIfGivenCustomEngineAndRacingDistance(
        racingCarList: List<RacingCar>,
        customEngine: Engine
    ) {
        // Arrange
        val racingCars = RacingCars(racingCarList = racingCarList)
        val currentRacingDistances = racingCars.currentRacingDistances

        // Act
        racingCars.races(customEngine)

        // Assert
        val racingDistancesAfterRace = racingCars.currentRacingDistances
        racingDistancesAfterRace.forEachIndexed { index, distance ->
            assertThat(distance).isEqualTo(currentRacingDistances[index] + MOVE_ONE_STEP)
        }
    }

    companion object {
        private const val MOVE_ONE_STEP = 1
        private val defaultRacingDistance = RacingDistance(0)

        @JvmStatic
        fun racingCarList(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        RacingCar(name = "람보르기니 우르스", racingDistance = defaultRacingDistance)
                    )
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "그랜저", racingDistance = defaultRacingDistance),
                        RacingCar(name = "소나타", racingDistance = defaultRacingDistance),
                        RacingCar(name = "아반떼", racingDistance = defaultRacingDistance)
                    )
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "K3", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K5", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K7", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K8", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K9", racingDistance = defaultRacingDistance)
                    )
                )
            )
        }

        @JvmStatic
        fun racingCarListAndCustomEngineWhatCylinderIsGreaterThanThree(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        RacingCar(name = "람보르기니 우르스", racingDistance = defaultRacingDistance)
                    ),
                    CustomEngine(4)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "그랜저", racingDistance = defaultRacingDistance),
                        RacingCar(name = "소나타", racingDistance = defaultRacingDistance),
                        RacingCar(name = "아반떼", racingDistance = defaultRacingDistance)
                    ),
                    CustomEngine(5)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "K3", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K5", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K7", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K8", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K9", racingDistance = defaultRacingDistance)
                    ),
                    CustomEngine(6)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "MT01", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT03", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT07", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT09", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT10", racingDistance = defaultRacingDistance),
                    ),
                    CustomEngine(7)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "스파크", racingDistance = defaultRacingDistance),
                        RacingCar(name = "크루즈", racingDistance = defaultRacingDistance),
                        RacingCar(name = "말리부", racingDistance = defaultRacingDistance),
                        RacingCar(name = "트랙스", racingDistance = defaultRacingDistance)
                    ),
                    CustomEngine(8)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "벤츠 A-class", racingDistance = defaultRacingDistance),
                        RacingCar(name = "벤츠 B-class", racingDistance = defaultRacingDistance),
                        RacingCar(name = "벤츠 C-class", racingDistance = defaultRacingDistance),
                        RacingCar(name = "벤츠 E-class", racingDistance = defaultRacingDistance),
                        RacingCar(name = "벤츠 G-class", racingDistance = defaultRacingDistance),
                        RacingCar(name = "벤츠 V-class", racingDistance = defaultRacingDistance),
                        RacingCar(name = "벤츠 X-class", racingDistance = defaultRacingDistance)
                    ),
                    CustomEngine(9)
                )
            )

        @JvmStatic
        fun customEnginesAndRacingDistances(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    CustomEngine(4),
                    RacingDistance(100)
                ),
                Arguments.of(
                    CustomEngine(5),
                    RacingDistance(100_000)
                ),
                Arguments.of(
                    CustomEngine(6),
                    RacingDistance(81_287_478)
                ),
                Arguments.of(
                    CustomEngine(7),
                    RacingDistance(181_938_115)
                ),
                Arguments.of(
                    CustomEngine(8),
                    RacingDistance(128_115)
                ),
                Arguments.of(
                    CustomEngine(9),
                    RacingDistance(2_115)
                )
            )
    }
}
