package _3_racing_car.service

import _3_racing_car.domain.Name
import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Car
import _3_racing_car.domain.racer.Racer
import _3_racing_car.service.dto.RacingInputDto
import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class RacingTest : BehaviorSpec({
    given("경주자들과 힘의 조건이 주어진 경우") {
        forAll(
            row(listOf("A", "B", "C"), listOf(4, 4, 3), 4, listOf("A", "B"), 4),
            row(listOf("A", "B", "C", "D"), listOf(4, 3, 4, 3), 3, listOf("A", "C"), 3),
            row(listOf("A", "B", "C"), listOf(3, 3, 3), 3, listOf("A", "B", "C"), 0),
        ) {
            gamers, powers, times, winners, maxLocation ->
            val racers = gamers.map { Car(Name(it)) }
            val racePowers = powers.map { Power { it } }
            val racingInput: Map<Racer, Power> = racers.zip(racePowers).toMap()
            val racing = Racing(RacingInputDto(racingInput))

            `when`("경주를 시작했을때") {
                val result = racing.start(times)

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
