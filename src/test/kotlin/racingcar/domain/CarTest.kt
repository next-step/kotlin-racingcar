package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({

    "자동차는 위치를 지정할 수 있다." {
        val position = 10
        val car = Car("제이든", position)

        car.position shouldBe position
    }

    "자동차는 이동할 수 있다." {
        val car = Car("제이든", moveStrategy = MoveStrategy { true })
        car.move()
        car.position shouldBe 1
    }

    "자동차는 이름을 갖는다." {
        val car = Car("제이든")
        car.name shouldBe "제이든"
    }

    "자동차의 이름은 공백일 수 없다." - {
        withData(
            nameFn = { "공백($it)" },
            "  ",
            "",
            "     "
        ) { carName ->
            val throws = shouldThrow<IllegalArgumentException> {
                Car(carName)
            }
            throws.message shouldBe "자동차의 이름은 공백일 수 없습니다."
        }
    }

    "자동차의 이름은 5자를 초과할 수 없다." - {
        withData(
            "일이삼사오육",
            "abcdefg",
            "1234567"
        ) { carName ->
            val throws = shouldThrow<IllegalArgumentException> {
                Car(carName)
            }
            throws.message shouldBe "자동차의 이름은 5자를 초과할 수 없다."
        }
    }
})
