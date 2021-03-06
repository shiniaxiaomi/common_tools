package aop.Demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Yingjie.Lu on 2018/8/7.
 */

@Component
@Aspect  // 指定当前类为切面类
public class StudentServiceAspect {

    //定义一个切点(方法名就是切点的id:pointCut())
    // 指定切入点表达式： 拦截哪些方法； 即为哪些类生成代理对象
    @Pointcut("execution(* aop.Demo2.StudentService.*(..))")
    public void pointCut(){
    }

    //前置通知(方法名可随意,只要配置文件中对应即可)
    @Before("pointCut()")
    public void doBefore(JoinPoint jp){
        System.out.println("前置通知 : 获取类名:"+jp.getTarget().getClass().getName());
        System.out.println("前置通知 : 获取方法名:"+jp.getSignature().getName());
        System.out.println("前置通知 : 开始添加学生:"+jp.getArgs()[0]);
    }

    //后置通知
    @After("pointCut()")
    public void doAfter(JoinPoint jp){
        System.out.println("后置通知 : 添加学生结束");
    }

    //环绕通知
    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        //在下面添加前置通知
        System.out.println("环绕通知 : 添加学生前");
        //在上面添加前置通知

        Object obj= pjp.proceed();//这里执行了原来的方法,并返回方法的返回值

        //在下面添加后置通知
        System.out.println("环绕通知 : 添加学生后");
        //在上面添加后置通知

        return obj;
    }

    //返回通知
    @AfterReturning("pointCut()")
    public void doAfterReturning(JoinPoint jp){
        System.out.println("返回通知 : 方法返回通知");
    }


    @AfterThrowing(throwing = "ex",pointcut = "pointCut()")
    public void doAfterThrowing(JoinPoint jp,Throwable ex){
        System.out.println("异常通知 : ");
        System.out.println("异常信息 : "+ex.getMessage());
    }

}
