package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 위치를 갖는다`() {
        val car = Car(0)

        car.position shouldBe 0
    }
}
