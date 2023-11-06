package racing.fixture

import racing.model.Car
import racing.model.Name

object CarFixture {

    val carFixtureOfBeforeStart: ArrayDeque<String> = ArrayDeque(
        listOf(
            "치즈",
            "양파",
            "소고기",
            "양상추",
            "토마토",
        )
    )

    val carFixtureStep1: ArrayDeque<Car> = ArrayDeque(
        listOf(
            Car(Name("치즈"), 0),
            Car(Name("양파"), 1),
            Car(Name("소고기"), 0),
            Car(Name("신선양상추"), 0),
            Car(Name("빨간토마토"), 1),
        )
    )

    val carFixtureStep2: ArrayDeque<Car> = ArrayDeque(
        listOf(
            Car(Name("치즈"), 1),
            Car(Name("양파"), 2),
            Car(Name("소고기"), 3),
            Car(Name("신선양상추"), 4),
            Car(Name("빨간토마토"), 5),
        )
    )

    val carFixtureOfAfterFinish: ArrayDeque<Car> = ArrayDeque(
        listOf(
            Car(Name("치즈"), 2),
            Car(Name("양파"), 4),
            Car(Name("소고기"), 6),
            Car(Name("신선양상추"), 8),
            Car(Name("빨간토마토"), 10),
        )
    )
}
