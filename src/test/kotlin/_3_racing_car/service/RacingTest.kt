package _3_racing_car.service

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Car
import _3_racing_car.service.dto.RacingInputDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.maps.shouldContainExactly

internal class RacingTest : BehaviorSpec({
    given("전진을 위한 힘의 조건들과 요청한 트랙수와 횟수가 주어진 경우") {
        forAll(
            row(3, listOf(4, 4, 4), listOf("A", "B", "C"), 3, mapOf("A" to 3, "B" to 3, "C" to 3)),
            row(4, listOf(4, 3, 4, 3), listOf("A", "B", "C", "D"), 3, mapOf("A" to 3, "B" to 0, "C" to 3, "D" to 0)),
            row(3, listOf(3, 3, 3), listOf("A", "B", "C"), 3, mapOf("A" to 0, "B" to 0, "C" to 0)),
        ) { trackCount, powers, names, times, expected ->
            val tracks = List(trackCount) {
                val power = Power { _, _ -> powers[it] }
                Track(Car(names[it]), power)
            }

            val input = RacingInputDto(tracks = tracks, times = times)

            `when`("경주를 시작했을때") {
                val racing = Racing()
                val result = racing.run(input)

                then("레이서의 위치 값들을 반환한다.") {
                    result shouldContainExactly expected
                }
            }
        }
    }
})
