package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `Car 생성`() {
        val cars = Cars.create(listOf("pobi", "crong"))
        Assertions.assertThat(cars.size).isEqualTo(2)
    }
}
