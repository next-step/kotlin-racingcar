package race

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CarsTest {
    @Test
    fun `moveAt은 주어진 이동 조건에 따라 움직인다`() {
        val cars = Cars(Names("a,b"))

        cars.moveAt(0, true)
        cars.moveAt(1, false)

        val expected = Cars(listOf(Car("a", 2), Car("b", 1)))
        assertThat(cars).isEqualTo(expected)
    }

    @Test
    fun `copy는 새로운 Cars 객체를 반환한다`() {
        val cars = Cars(Names("a,b"))
        val copiedCars = cars.copy()

        assertThat(copiedCars).isNotSameAs(cars)
    }

    @Test
    fun `Cars는 최소 1대 이상 입력해야 한다`() {
        assertAll(
            { assertThatIllegalArgumentException().isThrownBy { Cars(Names("")) } },
            {
                assertThatExceptionOfType(
                    IllegalArgumentException::class.java,
                ).isThrownBy { Cars(listOf()) }.withMessage("최소 1대 이상 입력 해주세요. 입력 값: []")
            },
        )
    }
}
