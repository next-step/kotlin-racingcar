package step3

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest() {
    @Test
    fun `car 생성 확인`() {
        val car = Car()
        car.position shouldBe 1
    }

    @Test
    fun `car의 position이 1씩 증가하는지 확인`() {
        // given
        val car = Car()

        // when
        car.progress()

        // then
        car.position shouldBe 2
    }
}
