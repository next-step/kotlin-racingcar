# kotlin-racingcar

## 🎯 요구사항 목록

- 계산 기능
    - 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행
    - 사칙 연산의 계산 우선순위가 아닌 입력 순서에 따라 연산 수행
    - 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행
- 유효성 검사
    - 입력값이 null, 빈 공백 문자일 경우 IllegalArgumentException 발생
    - 사칙연산 기호가 아닌 경우 IllegalArgumentException 발생

## 🚀 도전 과제

- [x] kotest Assertions 활용하기
- [x] JUnit5, kotest 차이점 학습

## 📚 학습 내용

| JUnit5                                             | kotest                  |
|----------------------------------------------------|-------------------------|
| 전통적인 Java 문법                                       | 간결하고 가독성 좋은 kotlin 문법   |
| CompletableFuture, @Timeout 등을 활용한 비동기 테스트 (다소 복잡) | 코루틴을 이용한 비동기 테스트  (직관적) |

**결론** - 언어(Java/Kotlin)에 대한 친숙도 고려 +
Junit의 안정적이고 방대한 플러그인 지원 vs kotest의 코루틴 지원을 비교하여 결정

**참고** - https://www.baeldung.com/kotlin/kotest-vs-junit-5
