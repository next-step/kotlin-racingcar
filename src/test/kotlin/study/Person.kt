package study

data class Person( // 프로퍼티: 접근자+필드 조합
    val name: String,
    val age: Int,
    var nickname: String? = "Guest" // 변경 가능 //기본값을 지정해두면 두개의 인자를 가진 생성자도 자동 생성
) // equals hashcode 자동 오버라이드,
