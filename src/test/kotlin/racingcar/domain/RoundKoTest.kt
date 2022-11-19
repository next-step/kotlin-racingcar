package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify

class RoundKoTest : BehaviorSpec({
    given("라운드 테스트") {
        `when`("참여할 자동차들이 선택되면") {
            val car = mockk<Car>()
            every { car.position } returns 0
            every { car.move(1) } returns 1

            val cars = listOf(car)

            and("라운드가 시작되고") {
                val round: Round = spyk(
                    Round(cars),
                    recordPrivateCalls = true
                )
                every { round["getNumberToMove"]() } returns 1

                then("자동차들이 움직인다.") {
                    round.start()

                    verify { round.start() }
                    verify { car.move(1) }
                }
            }
        }
    }
})
