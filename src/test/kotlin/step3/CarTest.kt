package step3

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CarTest {

    @MockK
    lateinit var movingStrategy: MovingStrategy

    @Test
    fun `1) 이동 성공`() {
        val car = Car.makeCar()
        every { movingStrategy.movable() } returns true
        car.move(movingStrategy)
        Assertions.assertThat(car.getPosition()).isEqualTo(1)
    }


    @Test
    fun `2) 이동 실패`() {
        val car: Car = Car.makeCar()
        every { movingStrategy.movable() } returns false
        car.move(movingStrategy)
        Assertions.assertThat(car.getPosition()).isEqualTo(0)
    }
}
