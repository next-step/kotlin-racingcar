package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `test move`() {
        Assertions.assertThat(Car.create().move().position).isEqualTo(2)
        Assertions.assertThat(Car.create().move().move().position).isEqualTo(3)
    }

    @Test
    fun `test toString`() {
        Assertions.assertThat(Car.create().toString()).isEqualTo("-")
        Assertions.assertThat(Car.create().move().toString()).isEqualTo("--")
    }
}
