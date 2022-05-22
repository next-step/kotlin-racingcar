package _3_racing_car.service

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Car
import _3_racing_car.service.dto.RacingInputDto
import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class RacingTest : BehaviorSpec({
    given("전진을 위한 힘의 조건들과 요청한 트랙수와 횟수가 주어진 경우") {
        forAll(
            row(3, listOf(4, 4, 3), listOf("A", "B", "C"), 4, listOf("A", "B"), 4),
            row(4, listOf(4, 3, 4, 3), listOf("A", "B", "C", "D"), 3, listOf("A", "C"), 3),
            row(3, listOf(3, 3, 3), listOf("A", "B", "C"), 3, listOf("A", "B", "C"), 0),
        ) { trackCount, powers, names, times, winners, maxLocation ->
            val tracks = List(trackCount) {
                val power = Power { _, _ -> powers[it] }
                Track(Car(names[it]), power)
            }

            val input = RacingInputDto(tracks = tracks, times = times)

            `when`("경주를 시작했을때") {
                val racing = Racing()
                val result = racing.run(input)

                then("최대 거리와 우승자를 반환한다.") {
                    assertSoftly(result) {
                        result.winners shouldBe winners
                        result.maxLocation shouldBe maxLocation
                    }
                }
            }
        }
    }
})
