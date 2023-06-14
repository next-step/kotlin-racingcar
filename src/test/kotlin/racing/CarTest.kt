package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.view.ResultView

class CarTest : AnnotationSpec() {

    @Test
    fun `자동차 이름은 5자를 넘을 수 없음`() {
        shouldThrow<IllegalArgumentException> {
            Car("minhyukseul")
        }
    }

    @Test
    fun `랜덤한 숫자를 생성하여 범위내에 들어오는지 확인`() {
        CarRandomGenerator.createRandom(10) shouldBeInRange 0..9
    }

    @Test
    fun `자동차가 움직일 경우 위치가 0이거나 1인지 확인`() {
        val car = Car("pobi")
        car.moveCar(4) shouldBe 1
        car.moveCar(3) shouldBe 1
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
