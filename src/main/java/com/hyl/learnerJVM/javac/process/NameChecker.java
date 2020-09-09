package com.hyl.learnerJVM.javac.process;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;

import static javax.lang.model.element.ElementKind.ENUM_CONSTANT;
import static javax.lang.model.element.ElementKind.FIELD;
import static javax.lang.model.element.ElementKind.INTERFACE;
import static javax.lang.model.element.ElementKind.METHOD;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;
import static javax.tools.Diagnostic.Kind.WARNING;

/**
 * @author hyl
 * @version v1.0: NameChecker.java, v 0.1 2020/9/8 23:23 $
 */
public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();

    }

    /**
     * 对Java程序命名进行检查。
     * <ul>
     *     <li> 类或接口：符合驼式命名法，首字母大写</li>
     *     <li> 方法：符合驼式命名法，首字母小写</li>
     *     <li>字段：
     *     <ul>
     *         <li> 类、实例变量：符合驼式命名法，首字母小写</li>
     *         <li> 常量：要求全部大写，下划线隔开</li>
     *     </ul>
     * </ul>
     *
     * @param element
     */
    public void checkNames(Element element) {
        nameCheckScanner.scan(element);
    }

    /**
     * 名称检查器实现类，继承了 JDK 8 中提供的  {@link javax.lang.model.util.ElementScanner8}  <br>
     * 将会以 Visitor 模式访问抽象语法树中的元素
     */
    private class NameCheckScanner extends ElementScanner8<Void, Void> {

        /**
         * 此方法用于校验Java 类
         *
         * @param e
         * @param unused
         * @return
         */
        @Override
        public Void visitType(TypeElement e, Void unused) {
            scan(e.getTypeParameters(), unused);
            checkCamelCase(e, true);
            return super.visitType(e, unused);
        }

        /**
         * 检查方法命名是否合法
         *
         * @param e
         * @param unused
         * @return
         */
        @Override
        public Void visitExecutable(ExecutableElement e, Void unused) {
            if (e.getKind() == METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement()
                    .getSimpleName())) {
                    messager.printMessage(WARNING, "一个普通方法 " + name + " 不应当与类名重复，避免与构造函数产生混淆", e);
                }
                checkCamelCase(e, false);
            }
            return super.visitExecutable(e, unused);
        }

        /**
         * 检查变量命名是否合法
         *
         * @param e
         * @param unused
         * @return
         */
        @Override
        public Void visitVariable(VariableElement e, Void unused) {
            if (e.getKind() == ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)) {
                checkAllCaps(e);
            } else {
                checkCamelCase(e, false);
            }

            return super.visitVariable(e, unused);
        }

        /**
         * 判断一个变量是否是常量
         *
         * @param e
         * @return
         */
        private boolean heuristicallyConstant(VariableElement e) {
            if (e.getEnclosingElement()
                .getKind() == INTERFACE) {
                return true;
            } else if (e.getKind() == FIELD && e.getModifiers()
                .containsAll(EnumSet.of(PUBLIC, STATIC, FINAL))) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 检查传入的 Element 是否符合驼峰命名法，如果不符合，则输出警告信息
         *
         * @param e
         * @param initialCaps
         */
        private void checkCamelCase(Element e, boolean initialCaps) {

            String name = e.getSimpleName()
                .toString();
            boolean previousUpper = false;
            boolean conventional = true;

            int firstCodePoint = name.codePointAt(0);

            if (Character.isUpperCase(firstCodePoint)) {
                previousUpper = true;
                if (!initialCaps) {
                    messager.printMessage(WARNING, "名称 " + name + " 应当以小写字母开头", e);
                    return;
                }
            } else if (Character.isLowerCase(firstCodePoint)) {
                if (initialCaps) {
                    messager.printMessage(WARNING, "名称 " + name + " 应当以大写字母开头", e);
                    return;
                }
            } else {
                conventional = false;
            }

            if (conventional) {
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {

                    cp = name.codePointAt(i);
                    if (Character.isUpperCase(cp)) {
                        if (previousUpper) {
                            conventional = false;
                            break;
                        }
                        previousUpper = true;
                    } else
                        previousUpper = false;
                }
                if (!conventional) {
                    messager.printMessage(WARNING, "名称 " + name + " 应当符合驼式命名法", e);
                }
            }

        }

        /**
         * 大写命名检查
         *
         * @param e
         */
        private void checkAllCaps(Element e) {
            String name = e.getSimpleName()
                .toString();

            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);

            if (!Character.isUpperCase(firstCodePoint)) {
                conventional = false;
            } else {
                boolean previousUnderscore = false;
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
                    cp = name.codePointAt(i);
                    if (cp == (int) '_') {
                        if (previousUnderscore) {
                            conventional = false;
                            break;
                        }
                        previousUnderscore = true;
                    } else {
                        previousUnderscore = false;
                        if (!Character.isUpperCase(cp) && !Character.isDigit(cp)) {
                            conventional = false;
                            break;
                        }
                    }
                }
            }

            if (!conventional) {
                messager.printMessage(WARNING, "常量 " + name + " 应当全部以大写字母或下划线命名", e);
            }
        }

    }

}
