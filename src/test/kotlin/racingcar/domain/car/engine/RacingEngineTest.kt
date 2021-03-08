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
    fun `threshold보다 낮으면 회전력(Torque)이 0 나오고, threshold보다 같거나 높으면 회전력(Torque)이 1 나온다`(
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
