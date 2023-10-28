package step3.carRacing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarGeneratorTest{
    @Test
    fun generate() {
        val cars = CarGenerator.generate(5)
        assertThat(cars).hasSize(5).extracting("curPosition").contains(0)
    }
}
