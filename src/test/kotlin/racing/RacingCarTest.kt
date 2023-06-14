package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.RacingGame
import racing.view.ResultView


class RacingCarTest : AnnotationSpec() {

    @Test
    fun `자동차는 이름을 가지고 최초 위치는 0을 가리킨다`() {
        val name = "poby"
        val car = Car(name)
        car.name shouldBe name
        car.position shouldBe 0
    }

    @Test
    fun `자동차 이름은 5글자가 넘을 수가 없음`() {
        shouldThrow<IllegalArgumentException> {
            Car("123456")
        }
    }

    @Test
    fun `자동차는 강도 4이상의 엑셀을 밟으면 움직 일 수 있음`() {
        val numbers = listOf(4, 5, 6, 7, 8, 9)
        val car = Car("Poby")
        numbers.forEach {
            car.moveCar(it) shouldBe true
        }

    }

    @Test
    fun `자동차는 강도 4미만의 엑셀을 밟으면 움직 일 수 없음`() {
        val numbers = listOf(0, 1, 2, 3)
        val car = Car("Poby")
        numbers.forEach {
            car.moveCar(it) shouldBe false
        }
    }

    @Test
    fun `자동차 이름은 쉼표로 구분함`() {
        val carNames = "pobi,crong,honux"
        InputParser.parse(carNames) shouldHaveSize(3)
    }

    @Test
    fun `0에서 9 사이에서 무작위 값을 구한다`() {
        repeat(5) {
            CarRandomGenerator.createRandom(RacingGame.MAX_BOUND) shouldBeInRange 0..9
        }
    }

    @Test
    fun `전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다`() {
        val carNames = "pobi,crong,honux"
        val cars = InputParser.parse(carNames).map { Car(it) }
        RacingGame.raceStart(cars)
        ResultView.showSkidMarks(cars)
    }
}
