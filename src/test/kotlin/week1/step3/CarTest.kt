package week1.step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `전진 조건이 아닐 경우`() {
        val car = Car("test").apply {
            setupDistanceLimitCondition()
        }
        assertThat(car.distanceCounts.last()).isLessThan(4)
    }

    @Test
    fun `전진 조건인 경우`() {
        val car = Car("test").apply {
            setupDistanceCondition()
        }
        assertThat(car.distanceCounts.last()).isGreaterThan(3)
    }

    @Test
    fun `차 이름이 5글자가 넘은 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car("abcdef")
        }
    }

    @Test
    fun `차 이름이 없는 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car()
        }
    }

    @Test
    fun `우승자가 한 명인 경우`() {
        val racingCar = mutableListOf<Car>().apply {
            add(Car(name = "aaa").apply { setupDistanceCondition() })
            add(Car(name = "bbb").apply { setupDistanceLimitCondition() })
            add(Car(name = "ccc").apply { setupDistanceLimitCondition() })
        }
        assertThat(racingCar.maxBy { it.distanceCounts.last() }?.distanceCounts?.last()).isEqualTo(racingCar[0].distanceCounts.last())
    }
}
