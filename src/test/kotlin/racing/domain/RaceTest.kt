package racing.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions

class RaceTest : StringSpec({
    "경주를 진행하고 경주 결과를 반환" {
        val race = Race(
            Players(2),
            GameCount(1),
            AlwaysMovingStrategy()
        )
        val cars = race.run()
        Assertions.assertThat(cars)
            .isEqualTo(
                listOf(
                    Car(Location(1)),
                    Car(Location(1))
                )
            )
    }

    "경주 진행 여부를 확인한다" {
        val race = Race(
            Players(2),
            GameCount(1),
            AlwaysMovingStrategy()
        )
        race.run()
        Assertions.assertThat(race.onPlay()).isFalse()
    }
})
