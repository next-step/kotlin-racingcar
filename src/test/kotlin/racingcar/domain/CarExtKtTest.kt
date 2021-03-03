package racingcar.domain

import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class CarExtKtTest {

    @Test
    internal fun `shouldMove가 true일 때`() {
        val car = spyk<Car>()
        car.moveOrStop(shouldMove = true)
        verify { car.move() }
    }

    @Test
    internal fun `shouldMove가 false일 때`() {
        val car = spyk<Car>()
        car.moveOrStop(shouldMove = false)
        verify { car.stop() }
    }
}
