package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차는 위치를 지정할 수 있다." {
        val position = 10
        val car = Car("제이든", position)

        car.position shouldBe position
    }

    "자동차는 이동할 수 있다." {
        val car = Car("제이든")
        car.move()
        car.position shouldBe 1
    }

    "자동차는 이름을 갖는다." {
        val car = Car("제이든")
        car.name shouldBe "제이든"
    }
})
