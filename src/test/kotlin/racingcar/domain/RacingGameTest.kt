package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.communication.output.OutputConsole
import racingcar.domain.cars.RacingCar
import racingcar.domain.cars.RacingCars
import racingcar.domain.engine.CustomEngine
import racingcar.domain.racing.FinalLab

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

    @DisplayName("실린더가 4 이상인 `CustomEngine`으로 생성된 `Cars`가 주어지면 `racing` 함수 호출 시 전진 성공")
    @Test
    fun moveOneStepIsSuccessIfGivenCarsWhatDependencyCustomEngine() {
        // Arrange
        val output = OutputConsole()
        val racingCars = RacingCars(racingCarList = listOf(RacingCar(name = "테스트용 카")))
        val finalLab = FinalLab(value = 1)
        val racingGame = RacingGame(output)

        // Act
        racingGame.race(racingCars = racingCars, finalLab = finalLab, engine = CustomEngine(4))
        val racingDistanceAfterRace = racingCars.currentRacingDistances

        racingDistanceAfterRace.forEach { racingLab ->
            assertThat(racingLab).isEqualTo(1)
        }
    }
}
