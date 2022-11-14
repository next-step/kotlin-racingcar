package study.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import racing.domain.RacingCar
import racing.domain.RacingCar.Companion.RANDOM_RANGE
import kotlin.random.Random
import kotlin.random.nextInt

class RacingCarTest : StringSpec({
    "0~9 중 4미만의 값이 발생하면 정지한다." {
        val car = RacingCar()

        mockkObject(Random.Default) {
            every { Random.nextInt(RANDOM_RANGE) } returns 3
            car.moveForward()
        }

        car.position shouldBe 1
    }

    "0~9 중 4이상의 값이 발생하면 전진한다." {
        val car = RacingCar()

        mockkObject(Random.Default) {
            every { Random.nextInt(RANDOM_RANGE) } returns 4
            car.moveForward()
        }

        car.position shouldBe 2
    }
})
