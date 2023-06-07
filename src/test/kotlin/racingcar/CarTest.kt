package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 현재 위치를 가진다`() {
        val actual = Car(1)
        actual.position shouldBe 1
    }
}
