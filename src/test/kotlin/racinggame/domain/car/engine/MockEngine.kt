package racinggame.domain.car.engine

class MockEngine(
    private val fixedDrivableDistance: DrivableDistance
) : Engine {

    override fun execute(): DrivableDistance {
        return fixedDrivableDistance
    }
}
