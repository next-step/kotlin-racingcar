package step3.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    fun `fromNames 의 인자로 이름을 ,로 나누어 전달한다`() {
        val carNameString = "pobi,crong,honux"

        val cars = Cars.fromNames(carNameString)

        Assertions.assertThat(cars.size).isEqualTo(3)
        Assertions.assertThat(cars[0].name).isEqualTo("pobi")
    }
}
