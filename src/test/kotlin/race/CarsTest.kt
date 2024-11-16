package race

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `moveAt은 주어진 이동 조건에 따라 움직인다`() {
        val cars = Cars(Names("a,b"))

        cars.moveAt(0, MoveCondition(PositiveNumber(4)))
        cars.moveAt(1, MoveCondition(PositiveNumber(3)))

        val expected = listOf(Car("a", 2), Car("b", 1))
        cars.forEachIndexed { index, car ->
            assertThat(car).isEqualTo(expected[index])
        }
    }

    @Test
    fun `copy는 새로운 Cars 객체를 반환한다`() {
        val cars = Cars(Names("a,b"))
        val copiedCars = cars.copy()

        assertThat(copiedCars).isNotSameAs(cars)
    }

    @Test
    fun `Cars는 최소 1대 이상 입력해야 한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Cars(Names(""))
        }
    }
}
