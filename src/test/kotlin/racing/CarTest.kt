package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange

class CarTest : AnnotationSpec() {

    @Test
    fun `자동차_이름이_5자가_넘는경우`() {
        Car("minhyukseul")
        shouldThrow<IllegalArgumentException> {
            "이름이 5자 넘어야함"
        }
    }

    @Test
    fun `자동차가 움직일 경우 위치가 0이거나 1인지 확인`() {
        val car = Car("pobi")
        car.moveCar(CarRandomGenerator.createRandom(10)) shouldBeInRange 0..1
    }

    @Test
    fun `자동차가 랜덤 값 5회 반복으로 범위 안에 들어오는지 확인`() {
        repeat(5) {
            val data = CarRandomGenerator.createRandom(10)
            println(data)
            data shouldBeInRange 0..9
        }
    }

    @Test
    fun `자동차 여러대를 생성해서 실제 우승자를 체크해봄`() {
        val cars = mutableListOf(Car("pobi"), Car("crong"), Car("honux"))
        ResultView.showResult(cars, 5)
    }
}
