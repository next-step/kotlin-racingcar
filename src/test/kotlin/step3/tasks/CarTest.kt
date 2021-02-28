package step3.tasks

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import step3.model.Car
import step3.util.Message.Companion.ONE_DISTANCE

@Suppress("NonAsciiCharacters")
class CarTest {

    @Test
    fun `자동차 1번 전진`() {
        val car = Car().apply {
            go()
        }

        Assertions.assertThat(car.whereIs())
            .isEqualTo(ONE_DISTANCE)
    }
}
