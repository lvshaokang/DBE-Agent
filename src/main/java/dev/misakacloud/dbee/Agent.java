package dev.misakacloud.dbee;

import dev.misakacloud.dbee.interceptor.Transformers;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an perform monitor agent.");
        AgentBuilder.Listener listener = new AgentBuilder.Listener() {
            @Override
            public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
            }

            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded, DynamicType dynamicType) {

            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {

            }

            @Override
            public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {

            }

            @Override
            public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {

            }

        };
        new AgentBuilder
                .Default()
                .type(ElementMatchers.nameContains("com.dbeaver.ee.runtime.lm.DBeaverEnterpriseLM$")) // 指定需要拦截的类
                .transform(Transformers.loadKeyTransformer)
                .with(listener)
                .installOn(inst);
    }

    public static void updateClassPath() {
//        try {
//            URLClassLoader child = new URLClassLoader (myJar.toURL(), this.getClass().getClassLoader());
//            Class classToLoad = Class.forName ("com.MyClass", true, child);
//            Method method = classToLoad.getDeclaredMethod ("myMethod");
//            Object instance = classToLoad.newInstance ();
//            Object result = method.invoke (instance);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }

}
