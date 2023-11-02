package racing.fixture

import racing.model.Car

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
            Car("치즈", 0),
            Car("양파", 1),
            Car("소고기", 0),
            Car("신선양상추", 0),
            Car("빨간토마토", 1),
        )
    )

    val carFixtureStep2: ArrayDeque<Car> = ArrayDeque(
        listOf(
            Car("치즈", 1),
            Car("양파", 2),
            Car("소고기", 3),
            Car("신선양상추", 4),
            Car("빨간토마토", 5),
        )
    )

    val carFixtureOfAfterFinish: ArrayDeque<Car> = ArrayDeque(
        listOf(
            Car("치즈", 2),
            Car("양파", 4),
            Car("소고기", 6),
            Car("신선양상추", 8),
            Car("빨간토마토", 10),
        )
    )
}
