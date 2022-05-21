package step5.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.model.Car

class CarTest {
    @Test
    fun `move`() {
        Assertions.assertThat(Car.create("").move().position).isEqualTo(2)
        Assertions.assertThat(Car.create("pobi").move().move().position).isEqualTo(3)
    }
}
