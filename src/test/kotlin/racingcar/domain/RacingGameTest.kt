package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.controller.RacingGame
import racingcar.view.output.OutputConsole
import racingcar.domain.cars.RacingCar
import racingcar.domain.cars.RacingCars
import racingcar.domain.engine.CustomEngine
import racingcar.domain.racing.FinalLab
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("자동차 경주 게임을 담당하는 객체인 `RacingGame` 테스트")
internal class RacingGameTest {
    @DisplayName("`Output` 구현체가 주어지면 `RacingGame` 생성 시 성공")
    @Test
    fun createRacingGameIsSuccessIfGivenOutputImplement() {
        // Arrange
        val output = OutputConsole()

        // Act
        val racingGame = RacingGame(output)

        // Assert
        assertThat(racingGame).isNotNull
    }

    @DisplayName("전진 가능한 엔진을 장착한 `Cars`와 `FinalLab` 주어지면 `FinalLab`만큼 전진 성공")
    @ParameterizedTest
    @MethodSource("racingCarsListAndFinalLab")
    fun moveOneStepIsSuccessIfGivenCarsWhatDependencyCustomEngine(racingCarList: List<RacingCar>, finalLab: FinalLab) {
        // Arrange
        val output = OutputConsole()
        val racingCars = RacingCars(racingCarList = racingCarList)
        val racingGame = RacingGame(output)

        // Act
        racingGame.race(
            racingCars = racingCars,
            finalLab = finalLab,
            engine = CustomEngine(4)
        )
        val racingDistanceAfterRace = racingCars.currentRacingDistances

        racingDistanceAfterRace.forEach { racingLab ->
            assertThat(racingLab).isEqualTo(finalLab.value)
        }
    }

    companion object {
        private val defaultRacingDistance = RacingDistance(0)

        @JvmStatic
        fun racingCarsListAndFinalLab(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        RacingCar(name = "K3", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K5", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K7", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K8", racingDistance = defaultRacingDistance),
                        RacingCar(name = "K9", racingDistance = defaultRacingDistance)
                    ),
                    FinalLab(value = 7)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "그랜저", racingDistance = defaultRacingDistance),
                        RacingCar(name = "소나타", racingDistance = defaultRacingDistance),
                        RacingCar(name = "아반떼", racingDistance = defaultRacingDistance)
                    ),
                    FinalLab(value = 10)
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
                    FinalLab(value = 3)
                ),
                Arguments.of(
                    listOf(
                        RacingCar(name = "MT01", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT03", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT07", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT09", racingDistance = defaultRacingDistance),
                        RacingCar(name = "MT10", racingDistance = defaultRacingDistance),
                    ),
                    FinalLab(value = 5)
                )
            )
    }
}
