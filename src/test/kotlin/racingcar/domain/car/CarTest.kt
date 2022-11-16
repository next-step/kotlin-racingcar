package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import racingcar.domain.car.engine.MovingEngine
import racingcar.domain.car.engine.implement.RandomMovingEngine

internal class CarTest : StringSpec({

    lateinit var movingEngine: MovingEngine

    beforeEach {
        movingEngine = RandomMovingEngine()
    }

    "자동차는 위치값을 갖는다" {
        val car = Car(movingEngine)
        val initPosition = car.currentPosition()
        initPosition.shouldNotBeNull()
    }

    "자동차는 움직이면 위치값이 변한다" {
        val car = Car(movingEngine)
        val initAttemptCount = car.attemptCount()
        car.move()
        val postAttemptCount = car.attemptCount()
        initAttemptCount shouldNotBe postAttemptCount
    }

    "자동차는 위치값이 같다고 해서 같은 객체가 아니다" {
        val firstCar = Car()
        val secondCar = Car()
        firstCar.move()
        secondCar.move()
        firstCar.currentPosition() shouldBe secondCar.currentPosition()
        firstCar shouldNotBe secondCar
    }

    "자동차가 이동을 시도했을 때, 시도한 횟수를 저장한다" {
        val car = Car(movingEngine)
        car.move()
        car.move()
        car.attemptCount() shouldBe 2
    }

    "자동차는 생성될 때 이름을 부여할 수 있다" {
        val car = Car(movingEngine, "ep")
        car.name.shouldNotBeNull()
    }

    "자동차의 이름은 5글자를 초과할 수 없다" {
        shouldThrow<IllegalArgumentException> { Car(movingEngine, "eastperson") }
    }
})
