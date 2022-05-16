package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racinggame.domain.car.Car
import racinggame.domain.engine.Engine
import racinggame.domain.model.RacingGameInput

class RacingGameTest {
    @Test
    fun `RacingGame을 시작하면 자동차들의 각 단계별 전진 정도를 모두 구할 수 있다`() {
        val names = listOf("one", "two", "three")
        val racingGameInput = RacingGameInput(names, 5)
        val engine = Engine { 1 }
        val racingGame = RacingGame.of(racingGameInput) { name ->
            Car(name, engine)
        }
        val result = racingGame.start()
        var proceedLevel = 1
        result.stepResults.forEach { racingStepResult ->
            assertAll(
                racingStepResult.racingGameStatusList.map { individualRacingStepStatus ->
                    { assertThat(individualRacingStepStatus.proceedLevel).isEqualTo(proceedLevel) }
                }
            )
            proceedLevel++
        }
    }
}
