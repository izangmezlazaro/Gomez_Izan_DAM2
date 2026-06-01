package examen.gomez.izan.dao;

import examen.gomez.izan.motores.MotorSQL;

public abstract class AbstractDAO<T>
        implements DAO<T> {

    protected MotorSQL motorSQL;

    public AbstractDAO(MotorSQL motorSQL) {
        this.motorSQL = motorSQL;
    }

    protected void printError(Exception e) {
        System.out.println("error" + e.getMessage());
    }

}