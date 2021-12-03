package racingcar.communication

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.util.ControlTower.judgeTheWinnersNames
import racingcar.util.ControlTower.judgeTheWinningRecord
import racingcar.domain.cars.RacingCar
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("우승자 판정 등을 담당하는 관제탑 객체인 `ControlTower` 테스트")
internal class ControlTowerTest {
    @DisplayName("경주차 목록이 주어지면 가장 멀리간 기록(우승 기록)을 판정하여 반환")
    @ParameterizedTest
    @MethodSource("racingCarsListAndExpectedWinningRecord")
    fun returnWinningRecordIsSuccessIfGivenRacingCarsList(racingCarsList: List<RacingCar>, expectedWinningRecord: Int) {
        // Arrange
        // Act
        val winningRecord = judgeTheWinningRecord(racingCarsList)

        // Assert
        assertThat(winningRecord).isEqualTo(expectedWinningRecord)
    }

    @DisplayName("경주차 목록과 가장 멀리 간 기록이 주어지면 우승한 차들의 이름 목록 반환")
    @ParameterizedTest
    @MethodSource("racingCarsListAndWinningRecordAndExpectedWinnersNames")
    fun returnWinnersNamesIsSuccessIfGivenRacingCarsList(
        racingCarsList: List<RacingCar>,
        expectedWinnersNames: List<String>
    ) {
        // Arrange
        val winningRecord = judgeTheWinningRecord(racingCarsList)

        // Act
        val winnersNames = judgeTheWinnersNames(racingCarsList = racingCarsList, winningRecord = winningRecord)

        // Assert
        assertThat(winnersNames).isEqualTo(expectedWinnersNames)
    }

    companion object {
        @JvmStatic
        fun racingCarsListAndExpectedWinningRecord(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        RacingCar(racingDistance = RacingDistance(0)),
                        RacingCar(racingDistance = RacingDistance(0)),
                        RacingCar(racingDistance = RacingDistance(0)),
                        RacingCar(racingDistance = RacingDistance(0)),
                        RacingCar(racingDistance = RacingDistance(0))
                    ),
                    0
                ),
                Arguments.of(
                    listOf(
                        RacingCar(racingDistance = RacingDistance(0)),
                        RacingCar(racingDistance = RacingDistance(10)),
                        RacingCar(racingDistance = RacingDistance(2)),
                        RacingCar(racingDistance = RacingDistance(3)),
                        RacingCar(racingDistance = RacingDistance(8))
                    ),
                    10
                ),
                Arguments.of(
                    listOf(
                        RacingCar(racingDistance = RacingDistance(100_000_000)),
                        RacingCar(racingDistance = RacingDistance(390_281_445)),
                        RacingCar(racingDistance = RacingDistance(69_111_423)),
                        RacingCar(racingDistance = RacingDistance(710_182)),
                        RacingCar(racingDistance = RacingDistance(1_000_000_000))
                    ),
                    1_000_000_000
                ),
                Arguments.of(
                    listOf(
                        RacingCar(racingDistance = RacingDistance(100_000)),
                        RacingCar(racingDistance = RacingDistance(281_445)),
                        RacingCar(racingDistance = RacingDistance(969_111_423)),
                        RacingCar(racingDistance = RacingDistance(710_182)),
                        RacingCar(racingDistance = RacingDistance(1_000_000))
                    ),
                    969_111_423
                ),
                Arguments.of(
                    listOf(
                        RacingCar(racingDistance = RacingDistance(19)),
                        RacingCar(racingDistance = RacingDistance(18)),
                        RacingCar(racingDistance = RacingDistance(14)),
                        RacingCar(racingDistance = RacingDistance(11)),
                        RacingCar(racingDistance = RacingDistance(11))
                    ),
                    19
                )
            )

        @JvmStatic
        fun racingCarsListAndWinningRecordAndExpectedWinnersNames(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        RacingCar(name = "소나타", racingDistance = RacingDistance(0)),
                        RacingCar(name = "그랜저", racingDistance = RacingDistance(0)),
                        RacingCar(name = "제네시스", racingDistance = RacingDistance(0)),
                        RacingCar(name = "아반떼", racingDistance = RacingDistance(0))
                    ),
                    listOf("소나타", "그랜저", "제네시스", "아반떼")
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "MT01", racingDistance = RacingDistance(0)),
                        RacingCar(name = "MT03", racingDistance = RacingDistance(10)),
                        RacingCar(name = "MT07", racingDistance = RacingDistance(2)),
                        RacingCar(name = "MT09", racingDistance = RacingDistance(3)),
                        RacingCar(name = "MT10", racingDistance = RacingDistance(8))
                    ),
                    listOf("MT03")
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "스파크", racingDistance = RacingDistance(100_000_000)),
                        RacingCar(name = "크루즈", racingDistance = RacingDistance(390_281_445)),
                        RacingCar(name = "말리부", racingDistance = RacingDistance(69_111_423)),
                        RacingCar(name = "트랙스", racingDistance = RacingDistance(710_182))
                    ),
                    listOf("크루즈")
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "벤츠 A-class", racingDistance = RacingDistance(100_000)),
                        RacingCar(name = "벤츠 B-class", racingDistance = RacingDistance(281_445)),
                        RacingCar(name = "벤츠 C-class", racingDistance = RacingDistance(969_111_423)),
                        RacingCar(name = "벤츠 E-class", racingDistance = RacingDistance(710_182)),
                        RacingCar(name = "벤츠 G-class", racingDistance = RacingDistance(969_111_423)),
                        RacingCar(name = "벤츠 V-class", racingDistance = RacingDistance(710_182)),
                        RacingCar(name = "벤츠 X-class", racingDistance = RacingDistance(281_445))
                    ),
                    listOf("벤츠 C-class", "벤츠 G-class")
                )
            )
    }
}
