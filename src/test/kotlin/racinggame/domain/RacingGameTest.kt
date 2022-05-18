package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racinggame.domain.car.Car
import racinggame.domain.engine.Engine
import racinggame.domain.model.RacingGameInput

class RacingGameTest {
    @Test
    fun `RacingGame을 시작하면 시도 횟수만큼의 stepResult를 얻을 수 있다`() {
        // given
        val names = listOf("one", "two", "three")
        val racingGameInput = RacingGameInput(names, 5)
        val engine = Engine { 1 }
        val racingGame = RacingGame.of(racingGameInput) { name ->
            Car(name, engine)
        }

        // when
        val result = racingGame.start()

        // then
        assertThat(result.stepResults.size).isEqualTo(5)
    }
}
