package racingcar

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CarTest : AnnotationSpec() {
    @Test
    fun `이동포인트가 4이상이면 1칸 이동한다`() {
        val sut = Car()

        sut.move(4)

        sut.position shouldBe 1
    }
}