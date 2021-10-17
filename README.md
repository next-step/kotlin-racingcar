# kotlin-racingcar
## 요구사항 정리

### 구현 목록
* [X] 덧셈
* [X] 뺄셈
* [X] 곱셈
* [X] 나눗셈
* [X] 예외
  * [X] 입력값이 null이거나 빈 공백 문자일 경우 부적절 인수 예외
  * [X] 사칙연산 기호가 아닌 경우 부적절 인수 예외

### 도메인 분리
* Input Domain
  * null 및 empty 예외 처리
  * 숫자와 사칙연산으로만 이루어져 있는지 확인
* 사칙연산 interface
* Input Domain 및 사칙연산 interface를 활용해서 결과값을 받는 Service Layer
