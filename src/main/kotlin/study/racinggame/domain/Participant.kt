package study.racinggame.domain
@JvmInline
value class Participant(val name: String) {
    init {
        if (name.isBlank() || name.length > 5) {
            throw InvalidParticipantNameException(name)
        }
    }
}

class InvalidParticipantNameException (name: String) : RuntimeException("참가자 이름은 공백 또는 5글자를 초과할 수 없습니다.. (name = $name)")
