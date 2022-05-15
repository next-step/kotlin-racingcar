package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.CarFixture.car

class CarTest : AnnotationSpec() {
    @Test
    fun `자동차는 0-9사이 무작위 값이 4 이상일때 움직인다`() {
        val randomNumber = (4..9).random()
        val resultCarPosition = car.move(randomNumber)
        resultCarPosition shouldBe car.position.plus(1)
    }

    @Test
    fun `자동차는 0-9사이 무작위 값이 4 미만이면 움직이지 않는다`() {
        val randomNumber = (0..3).random()
        val resultCarPosition = car.move(randomNumber)
        resultCarPosition shouldBe car.position
    }
}
