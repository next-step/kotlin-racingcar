package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `test move`() {
        Assertions.assertThat(Car().move()).isEqualTo(Car(2))
        Assertions.assertThat(Car().move().move()).isEqualTo(Car(3))
        Assertions.assertThat(Car(2).move()).isEqualTo(Car(3))
    }

    @Test
    fun `test toString`() {
        Assertions.assertThat(Car().toString()).isEqualTo("-")
        Assertions.assertThat(Car(2).toString()).isEqualTo("--")
    }
}
