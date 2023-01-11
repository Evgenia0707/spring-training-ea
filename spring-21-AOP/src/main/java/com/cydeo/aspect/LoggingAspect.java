package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component//Spring use class
public class LoggingAspect {//put info in console when use

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);//put info in console - like sout
// Logger from org.slf4j - simply login fasad for java
//getLogger give logger obj - from LoggingAspect.class - if have - just give that one , if don't have - create


//log some info before () run in class controller
//    public void test() {
//        logger.info("Information about application");
//    }


//define JoinPoint by creating PointCut
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))") //what () we run inside controller we see log in console
//    public void myPointCut(){};//which step wont my logger
//
//what to do @Before
//    @Before("myPointCut()")//run this () before any ()s in class
//    public void log(){
//        logger.info("Info log............");
//    }
//
//check () execute(any return type accept - provide pack name(com.cydeo.controller), class name(CourseController),
// (.*) any ()  name JoinPoint (..) any param

//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")//pointCut expression can be inside// will use only for this()
//    public void log(){
//        logger.info("Info log............");
//    }




//
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")//put logInfo before id () inside course  (findById - joinPoint)
//    public void courseRepositoryFindByIdPC(){}
//
//ADVICE
//    @Before("courseRepositoryFindByIdPC()")//create () what need to be happened
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){//implem bef or after (JoinPoint), can give info//JoinPoint - find info about () what want to run
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());//replace {}
//        //getSignature() - name, param, what () running
//{} work only with info or logger () (debug worning)//user controller obj = target
//    } //Before -> Method: Optional org.springframework.data.repository.CrudRepository.findById(Object), Arguments: [2]
////, Target: org.springframework.data.jpa.repository.support.SimpleJpaRepository@6f4953ba  -- here () run for real



//    @Pointcut("within(com.cydeo.controller..*)") //pack name ..-any () name, subpackges ->JoinPoint
//    public void anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")  //(give annot on top on class)all () inside classes - JP
//    public void anyServiceOperation(){}//import org.springframework.stereotype.Service;
////COMBINE
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"  // INFO , bec .info
//               , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }// : Before -> Method: CourseDTO com.cydeo.controller.CourseController.getCourseById(Long), Arguments: [2], Target: com.cydeo.controller.CourseController@1c0cf193
//    //    CourseController@1c0cf193 == Bean
//    //: Before -> Method: CourseDTO com.cydeo.service.impl.CourseServiceImpl.getCourseById(long), Arguments: [2], Target: com.cydeo.service.impl.CourseServiceImpl@67b3960b

//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")//if have this annotation run next @Before
////before do this -- go to controller - copy
//    public void anyDeleteControllerOperation() {
//    }
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }//Before -> Method: void com.cydeo.controller.CourseController.deleteCourseById(Long), Arguments: [2], Target: com.cydeo.controller.CourseController@55e5415d



//use custom annotation (created in annotation pack)
//    @Pointcut("@annotation(com.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC(){}
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }//Before -> Method: CourseDTO com.cydeo.controller.CourseController.getCourseById(Long), Arguments: [2], Target: com.cydeo.controller.CourseController@146833a2





    //defain JP () - which have @
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation(){}
//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")//getMapp () should ret result - log this info
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result){//need creat param ==result
//        logger.info("After Returning -> Method: {}, Result: {}",joinPoint.getSignature(), result.toString() );//result obj
//    }//After Returning -> Method: CourseDTO com.cydeo.controller.CourseController.getCourseById(Long),
    // Result: CourseDTO(id=2, name=Getting Started with Spring Security DSL, category=Spring, rating=3, description=Learn Spring Security DSL in easy steps)

    //return result --- how its look in Postman
//    "id": 2,
//    "name": "Getting Started with Spring Security DSL",
//    "category": "Spring",
//    "rating": 3,
//    "description": "Learn Spring Security DSL in easy steps"



///@AfterReturning
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation(){}
//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")//returning = "results" -> coming like List<CourseDTO>
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results){//List<CourseDTO> -
//        logger.info("After Returning -> Method: {}, Result: {}",joinPoint.getSignature(), results.toString() );//result obj
//    }
//    //CourseDTO -can return Object   --its child of Object  -->This is ok
//    //list<CourseDTO> -> List<Object>   ---> This is not ok
//    //casting List<Object> to List<CourseDTO> or List of any other object won't work


   // @AfterThrowing
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation(){}
//
//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingAnnotation(JoinPoint joinPoint, RuntimeException exception) {// "exception"==exception
//        logger.error("After Throwing > Method: {}, Exception: {}"
//                , joinPoint.getSignature().toShortString(), exception.getMessage());//toShortString - show short
//    }//After Throwing > Method: CourseController.getAllCourses(), Exception: My exception




//@Around
    @Pointcut("@annotation(com.annotation.LoggingAnnotation)")//my own annot
    public void loggingAnnotationPC(){}

    @Around("loggingAnnotationPC()")//return obj
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before > Method: {}, Parameter: {} "
                ,proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        Object result = null;//create obj

        //define part before
        try {
            result = proceedingJoinPoint.proceed();//run real ()-> getCourseById(@PathVariable("id") Long courseId) return CourseDTO
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }//and after JP
        logger.info("After -> Method: {} - Result: {}"
        ,proceedingJoinPoint.getSignature().toShortString(), result.toString());

        return result;
    }
//Before > Method: CourseController.getCourseById(..), Parameter: [3]
//After -> Method: CourseController.getCourseById(..) - Result: CourseDTO(id=3, name=Scalable, Cloud Native Data Applications, category=Spring, rating=4, description=Manage Cloud based applications with Spring Boot)
}