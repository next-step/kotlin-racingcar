package racing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.CarFactory

class CarFactoryTest {

    @Test
    fun `차 이름이 5글자를 초과하면, IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            CarFactory().createCars(listOf("BrunoMars"))
        }
    }
}
