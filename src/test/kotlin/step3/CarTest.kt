package step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class CarTest {
    private val car = Car("test")

    @Test
    fun `Car 는 move()하면 position 이 1 증가한다`() {
        assertThat(car.position).isEqualTo(0)

        car.move()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `makeCars 의 인자로 이름을 ,로 나누어 전달한다`() {
        val carNameString = "pobi,crong,honux"

        val cars = Cars.fromNames(carNameString)

        assertThat(cars.size).isEqualTo(3)
        assertThat(cars[0].name).isEqualTo("pobi")
    }

    @Test
    fun `Car 의 name 은 5자를 초과할 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car("name12")
        }
    }
}
