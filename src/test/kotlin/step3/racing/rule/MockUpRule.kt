package step3.racing.rule

class MockUpRule : CarMovementRule {
    var hasBeenCalled = false
    override val rule = {
        hasBeenCalled = true
        true
    }
}
