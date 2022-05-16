package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Created by Jaesungchi on 2022.05.16..
 */
class CarFactoryTest {
    @Test
    fun `이름갯수만큼 차량이 만들어지는가`() {
        assertThat(CarFactory.createCars(listOf("link", "james", "jason")).size).isEqualTo(3)
    }
}