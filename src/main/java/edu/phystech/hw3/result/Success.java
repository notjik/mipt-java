package edu.phystech.hw3.result;

import java.util.function.Function;

/**
 * @author notjik & kzlv4natoly
 */
public record Success<T>(T value) implements Result<T> {
    @Override
    public boolean isFailure() {
        return false;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public T getOrDefault(T defaultValue) {
        return value;
    }

    @Override
    public Throwable getExceptionOrNull() {
        return null;
    }

    @Override
    public <R> Result<R> map(Function<T, R> transform) {
        try {
            return new Success<>(transform.apply(value));
        } catch (Throwable e) {
            return new Failure<>(e);
        }
    }
}
