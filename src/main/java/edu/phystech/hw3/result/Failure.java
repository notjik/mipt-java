package edu.phystech.hw3.result;

import java.util.function.Function;

public record Failure<T>(Throwable e) implements Result<T> {
    @Override
    public boolean isFailure() {
        return true;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public T getOrDefault(T defaultValue) {
        return defaultValue;
    }

    @Override
    public Throwable getExceptionOrNull() {
        return e;
    }

    @Override
    public <R> Result<R> map(Function<T, R> transform) {
        return new Failure<>(e);
    }
}