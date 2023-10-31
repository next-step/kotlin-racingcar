package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlin.random.Random

class CarTest : StringSpec({
    beforeTest {
        mockkObject(Random)
    }
    afterTest {
        unmockkObject(Random)
    }

    "전진하는 조건을 만족하면 자동차는 전진한다. " {
        val carName = "정명구"
        val car = Car.create(carName)
        every { Random.nextInt(Car.getRandomRange()) } returns Car.getMoveThreshold()

        car.move()

        car.display() shouldBe "$carName : -"
    }

    "전진하는 조건을 만족하지 못하면 자동차는 전진하지 않는다" {
        val carName = "정명구"
        val car = Car.create(carName)
        every { Random.nextInt(Car.getRandomRange()) } returns Car.getMoveThreshold() - 1

        car.move()

        car.display() shouldBe "$carName : "
    }

    "이름의 길이가 지정한 범위 보다 크면 예외가 발생한다." {
        val carName = "정명구정명구"
        val nameRange = Car.getNameRange()

        nameRange shouldBe 5
        shouldThrow<IllegalArgumentException> {
            Car.create(carName)
        }
    }
})
