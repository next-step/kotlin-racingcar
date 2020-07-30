package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarFactory.makeCars

class CarFactoryTest {

    @Test
    fun `make cars`() {
        val names = listOf("a", "b")
        assertThat(makeCars(names)[0]).isEqualTo("a")
        assertThat(makeCars(names)[1]).isEqualTo("b")
        assertThat(makeCars(names).size).isEqualTo(2)
    }
}
