package racingcar.domain.car.engine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RacingEngineTest {
    @ParameterizedTest
    @CsvSource(
        "0, 0, MOVE",
        "3, 0, STOP",
        "3, 1, STOP",
        "3, 2, STOP",
        "3, 3, MOVE",
        "3, 4, MOVE",
        "3, ${Int.MAX_VALUE}, MOVE"
    )
    fun `임계값(threshold)보다 낮으면 움직일 회전력(MOVE)이 나오고, 임계값보다 같거나 높으면 움직일 수 없다(STOP)`(
        threshold: Int,
        force: Int,
        torque: Torque
    ) {
        val engine = RacingEngine(
            threshold = Force(threshold),
            forceGenerator = object : ForceGenerator {
                override fun generate() = Force(force)
            }
        )

        assertThat(engine.run()).isEqualTo(torque)
    }
}
