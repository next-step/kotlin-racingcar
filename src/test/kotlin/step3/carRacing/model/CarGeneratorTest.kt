package step3.carRacing.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import step3.carRacing.CarGenerator

internal class CarGeneratorTest{
    @Test
    fun generate() {
        val cars = CarGenerator.generate(5)
        assertThat(cars).hasSize(5).extracting("curPosition").contains(0)
    }
}
