package _3_racing_car.service

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Car
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

internal class TrackTest : BehaviorSpec({
    given("전진하는 힘의 조건에 만족한 경우") {
        val power = mockk<Power>()
        every { power.create() } returns 4
        val track = Track(Car(), power)

        `when`("트랙에서 경주 했을때") {
            val times = 5
            val position = track.run(times)

            then("횟수만큼 레이서는 움직인다.") {
                position shouldBe times
            }
        }
    }

    given("전진하는 힘의 조건에 만족하지 않은 경우") {
        val power = mockk<Power>()
        every { power.create() } returns 3
        val track = Track(Car(), power)

        `when`("트랙에서 경주 했을때") {
            val times = 5
            val position = track.run(times)

            then("레이서는 멈춰있다.") {
                position shouldBe 0
            }
        }
    }
})
