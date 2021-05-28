//package ru.kpfu.itis.hotel.aspects;
//
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//
///**
// * 07.04.2021
// * 06.Hotel
// *
// * @author Shamil Nurkaev @nshamil
// * 11-903
// */
//
//@Component
//@Aspect
//// @Slf4j
//public class LoggingAspect {
//
//    private static final Logger log
//            = (Logger) LoggerFactory.getLogger(LoggingAspect.class);
//
//    @Pointcut("@annotation(ru.kpfu.itis.hotel.aspects.Loggable)")
//    public void aspectAnnotation() {
//    }
//
//    @Around("aspectAnnotation()")
//    public Object logControllers(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("PRIVET");
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = joinPoint.getSignature().getName();
//
//        UserDetails userDetails;
//        // Выполним действие до вызова метода на Target.
//        try {
//            // Выводим сообщение об успешном соединении пользователя, который прошёл аутентификацию.
//            // Если пользователь не аутентифицировался, обрабатывается исключение -- выводим другое сообщение.
//            userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            log.info(String.format("[USER HAS CONTACTED userName=%s, className=%s, methodName=%s]",
//                    userDetails.getUsername(), className, methodName));
//        } catch (Exception exception) {
//            log.info(String.format("[UNIDENTIFIED USER classname=%s, methodName=%s]",
//                    className, methodName));
//        }
//
//        // Вызываем метод на Target.
//        Object retVal = joinPoint.proceed();
//
//        // Выполним действие после вызова метода на Target.
//        try {
//            // Выводим сообщение об успешном соединении пользователя, который прошёл аутентификацию.
//            // Если пользователь не аутентифицировался, обрабатывается исключение -- выводим другое сообщение.
//            userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            log.info(String.format("[GOT A RESPONSE userName=%s, className=%s, methodName=%s]",
//                    userDetails.getUsername(), className, methodName));
//        } catch (Exception exception) {
//            log.info(String.format("[UNIDENTIFIED USER GOT A RESPONSE classname=%s, methodName=%s]",
//                    className, methodName));
//        }
//
//        return retVal;
//    }
//}
