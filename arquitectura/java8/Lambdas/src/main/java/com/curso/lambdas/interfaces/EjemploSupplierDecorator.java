/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

import java.util.function.Supplier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Chema
 */
/*
Function<T,R> R apply(T t) Represents a function that takes an argument of type T
and returns a result of type R.

BiFunction<T,U,R> R apply(T t, U u) Represents a function that takes two arguments of types T
and U, and returns a result of type R.

Predicate<T> boolean test(T t) In mathematics, a predicate is a boolean-valued function
that takes an argument and returns true or false. The
function represents a condition that returns true or false
for the specified argument.

BiPredicate<T,U> boolean test(T t, U u) Represents a predicate with two arguments.
Consumer<T> void accept(T t) Represents an operation that takes an argument, operates
on it to produce some side effects, and returns no result.

BiConsumer<T,U> void accept(T t, U u) Represents an operation that takes two arguments,
operates on them to produce some side effects, and
returns no result.

Supplier<T> T get() Represents a supplier that returns a value.

Consumer<T> void accept(T t) Represents an operation that accepts a single input argument
and returns no result. Unlike most other functional interfaces, {@code Consumer} is expected
to operate via side-effects.

UnaryOperator<T> T apply(T t) Inherits from Function<T,T>. Represents a function that
takes an argument and returns a result of the same type.

BinaryOperator<T> T apply(T t1, T t2) Inherits from BiFunction<T,T,T>. Represents a function
that takes two arguments of the same type and returns a
result of the same.
*/
public class EjemploSupplierDecorator {

    private final Log log = LogFactory.getLog(EjemploSupplierDecorator.class);

    public void debug(Supplier<String> mensaje) {
        if (log.isDebugEnabled()) {
            log.debug(mensaje.get());
        }
    }
}
