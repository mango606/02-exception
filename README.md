# 👩‍💻Spring Boot Web

## 01. Response Entity
|String|일반 Text Type 응답|
|---|---|
|Object|자동으로 Json 변환되어 응답|
|ResponseEntity|Body의 내용을 Object로 설정, 상황에 따라서 HttpStatus Code 설정|
|@ResponseBody|RestController가 아닌 곳(Controller)에서 Json 응답을 내릴 때|

## 02. Spring Boot의 다양한 기능
- `ObjectMapper` 직렬화, 역직렬화

## 03. Spring Boot에서의 예외처리 - 1
- `ControllerAdvice`를 통해 예외를 잡는 방법
- ControllerAdvice는 REST API가 사용하는 곳에서 예외가 일어나는 것을 감지함.
- ExceptionHandler 구현

## 04. Spring Boot에서의 예외처리 - 2
- ControllerAdive는 여러 개의 Controller 중에서도 모든 예외를 잡아주는 **글로벌한 컨트롤러 예외 핸들러**임.
- (1) 직접 Controller(`ExceptionHandler`)에서 따로 예외를 처리하는 방법(ControllerAdvice에 전달되지 않음)
- (2) `basePakages`를 통해서 예외를 처리하는 방법
- basePakages로 exception의 Controller Pakage 하위에 있는 Controller는 해당 Handler가 잡음.
- (3) `basePackageClasses`에 클래스를 지정해서 예외를 처리하는 방법
- (4) 커스텀한 어노테이션을 통해 예외를 처리하는 방법

## 05. Spring Boot에서의 예외처리 - 3
- 객체 생성 시 build 패턴 사용(`@build`)
- build 패턴: 체인된 방식으로 한 가지를 빌드하는 것처럼 이어지는 패턴
- 데이터가 언제든 다른 내용으로 바뀔 수 있도록 제네릭 타입으로 선언함.(Api 클래스)
- 없는 데이터를 입력하면 body의 내용이 아무것도 없는 문제를 해결하기 위해 예외 핸들러(noSuchElement) 추가
- ExceptionHandler를 통해서 있을 때와 없을 때 항상 서버가 동일한 내용을 내려주도록 처리할 수 있음.