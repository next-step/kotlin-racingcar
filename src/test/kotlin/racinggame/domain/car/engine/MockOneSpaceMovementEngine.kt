package racinggame.domain.car.engine

class MockOneSpaceMovementEngine : Engine {

    override fun execute(): DrivableDistance {
        return DrivableDistance(1)
    }
}
