package utilities;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
// import java.lang.reflect.InvocationTargetException;
// import java.lang.reflect.Method;
import java.util.Vector;
import java.util.stream.Collectors;

public class ClassesInPackage {

    public Vector<Class<?>> getAllClassIn(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Vector<Class<?>> classes = new Vector<Class<?>>();
        // get the classes
        reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet()).forEach(el -> classes.add(el));
        return classes;
    }

    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    public Vector<Class<?>> getAnnotedClass(Class<? extends Annotation> annotation, String packageName) {
        Vector<Class<?>> classes = this.getAllClassIn(packageName);
        Vector<Class<?>> targetClass = new Vector<Class<?>>();
        for (Class<?> cla : classes) {
            if (cla.isAnnotationPresent(annotation)) {
                targetClass.add(cla);
                System.out.println(cla.getSimpleName() + " (Class) is annoted with " + annotation.getSimpleName());
                System.out.println("Value :");
                Annotation[] anot = cla.getAnnotations();
                for (int i = 0; i < anot.length; i++) {
                    System.out.println("\t - " + anot[i]);
                }
            }
        }
        return targetClass;
    }

    public Vector<Field> getAnnotedField(Class<? extends Annotation> annotation, Class<?> cla) {
        Field[] fields = cla.getDeclaredFields();
        Vector<Field> result = new Vector<Field>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(annotation)) {
                result.add(field);
                System.out.println(field.getName() + " (Field) is annoted with " + annotation.getSimpleName());
                System.out.println("Value :");
                Annotation[] anot = field.getAnnotations();
                for (int i = 0; i < anot.length; i++) {
                    System.out.println("\t - " + anot[i]);
                }
            }
        }
        return result;
    }

    // public void getValueIdk()
    // throws SecurityException, ClassNotFoundException, IllegalAccessException,
    // InvocationTargetException {
    // // Remove this function when you know what to do
    // Method[] methods = Class.forName("Compo.Student").getDeclaredMethods();
    // for (Method meth : methods) {
    // if (meth.isAnnotationPresent(Meth.class)) {
    // // for targeting one annotation and get the value of attr
    // Meth methAnnot = meth.getAnnotation(Meth.class);
    // System.out.println(methAnnot.status());
    // Method[] methodsAnno = methAnnot.getClass().getDeclaredMethods();
    // // for (int i = 0; i < methodsAnno.length; i++) {
    // // // methodsAnno[i].setAccessible(true);
    // // // methodsAnno[i].invoke(methAnnot);
    // // }
    // }
    // }
    // }

}
