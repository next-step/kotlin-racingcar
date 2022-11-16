package racingcar.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import racingcar.domain.car.engine.MovingEngine
import racingcar.domain.car.engine.implement.DefaultMovingEngine

class ParticipatingCarsTest : FunSpec({

    lateinit var movingEngine: MovingEngine
    val carSize = 3
    val carList = mutableListOf<Car>()
    lateinit var participatingCars: ParticipatingCars

    beforeTest {
        movingEngine = DefaultMovingEngine()
        IntRange(start = 1, endInclusive = carSize).forEach { _ ->
            carList.add(Car(movingEngine))
        }
        participatingCars = ParticipatingCars(carList.toList())
    }

    test("참여하는 자동차는 자동차 리스트를 인자로 생성한다.") {
        participatingCars.shouldNotBeNull()
    }

    test("레이스 초기화시 출력 함수를 인자로 넘길 수 있다") {
        val outputFunction: (String) -> Unit = { carName -> println("$carName 출력완료") }
        participatingCars.initRace(outputFunction)
    }
})
