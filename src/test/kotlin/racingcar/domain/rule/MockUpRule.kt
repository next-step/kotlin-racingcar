package racingcar.domain.rule

class MockUpRule : CarMovementRule {
    var hasBeenCalled = false
    override val rule = {
        hasBeenCalled = true
        true
    }
}
