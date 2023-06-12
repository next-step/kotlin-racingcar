package racinggame.domain.car.engine

class MockNotMoveEngine : Engine {

    override fun execute(): DrivableDistance {
        return DrivableDistance(0)
    }
}
