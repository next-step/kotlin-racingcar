package racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange
import java.lang.IllegalArgumentException

class CarTest : AnnotationSpec() {

    @Test
    fun `자동차_이름이_5자가_넘는경우`() {
        Car("minhyukseul")
    }

    @Test
    fun `자동차가 움직일 경우 위치가 0이거나 1인지 확인`() {
        val car = Car("pobi")
        car.moveCar() shouldBeInRange 0..1
    }

    @Test
    fun `자동차 여러대를 생성해서 실제 우승자를 체크해봄`() {
        val cars = mutableListOf(Car("pobi"), Car("crong"), Car("honux"))
        ResultView.showResult(cars, 5)
    }
}
