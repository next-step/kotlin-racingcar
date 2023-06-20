package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차의 기본 위치는 0이다`() {
        val car = Car()

        car.position shouldBe 0
    }
}
