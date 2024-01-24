package com.example;

public class StubBankService implements BankService{
    private int called = 0;
    private boolean isException;
    @Override
    public void pay(String id, double amount) {
        if (called == 1 && isException) throw  new RuntimeException("Somthing went wrong this payment");
        called++;
    }

    public void setException(boolean exception) {
        isException = exception;
    }

    public int getCalled() {
        return called;
    }
}
