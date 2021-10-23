package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.engine.CarEngine
import racingcar.manager.RacingManager

class RacingManagerTest {

    private lateinit var racingManager: RacingManager

    @Test
    fun `race() 후 전부 움직였을 경우 position을 테스트`() {
        // given
        val engine = object : CarEngine { override fun execute(): Boolean = true }
        racingManager = RacingManagerFactory().createRacingManager(3, engine)

        // when
        racingManager.race()

        // then
        assertThat(racingManager.getPositions()).isEqualTo(listOf(1, 1, 1))
    }
}
