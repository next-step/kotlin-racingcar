package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.constant.Constant
import racingcar.engine.GoEngine

class EngineTest {
    @Test
    fun `전진하면 거리가 한칸 늘어난다`() {
        val engine = GoEngine()
        assertEquals(engine.forward(Car.READY_STATUS), Constant.ONE_SPACE)
    }
}
