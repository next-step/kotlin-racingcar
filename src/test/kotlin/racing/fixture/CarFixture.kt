package racing.fixture

import racing.model.Car

class CarFixture {
    companion object {

        val carFixtureOfBeforeStart: ArrayDeque<String> = ArrayDeque(
            listOf(
                "치즈",
                "양파",
                "소고기",
                "양상추",
                "토마토",
            )
        )

        val carFixtureOfAfterFinish: ArrayDeque<Car> = ArrayDeque(
            listOf(
                Car("까망베르", 2),
                Car("적양파", 4),
                Car("살치살", 6),
                Car("신선한양상추", 8),
                Car("잘익은토마토", 10),
            )
        )
    }
}
