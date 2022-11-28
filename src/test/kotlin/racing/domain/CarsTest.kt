package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.MoveStrategy

class CarsTest : StringSpec({
    val moveStrategy: MoveStrategy = MoveStrategy { true }
    lateinit var movableCarNames: List<Name>
    lateinit var movableCars: List<Car>

    beforeTest {
        movableCarNames = listOf(Name.of("tobi"), Name.of("tom"))
        movableCars = movableCarNames.map { Car(moveStrategy = moveStrategy, name = it) }
    }

    "자동차들이 모두 정상이면, 모두 움직인다." {
        val cars = Cars(movableCars)
        val expectedCars = Cars(movableCarNames.map { Car(moveStrategy = moveStrategy, distance = 1, name = it) })

        cars.move()

        cars shouldBe expectedCars
    }

    "가장 멀리 이동한 자동차가 우승한다." {
        val brokenCarUserNames = listOf(Name.of("mimi"), Name.of("jin"))
        val brokenCars = brokenCarUserNames.map { Car(moveStrategy = MoveStrategy { false }, name = it) }
        val cars = Cars(movableCars.plus(brokenCars))

        cars.move()

        cars.getWinners() shouldBe movableCarNames
    }
})
