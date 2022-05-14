package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CarTest : AnnotationSpec() {
    @Test
    fun `이동포인트가 4이상이면 1칸 이동한다`() {
        val sut = Car()

        sut.move(4)

        sut.position shouldBe 1
    }

    @Test
    fun `이동포인트가 4미만이면 이동하지않는다`() {
        val sut = Car()

        sut.move(3)

        sut.position shouldBe 0
    }
}
