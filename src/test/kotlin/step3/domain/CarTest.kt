package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import step3.domain.Car
import step3.domain.Cars

internal class CarTest {
    private val car = Car("test")

    @Test
    fun `Car 는 move()하면 position 이 1 증가한다`() {
        assertThat(car.position).isEqualTo(0)

        car.move()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car 의 name 은 5자를 초과할 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car("name12")
        }
    }
}
