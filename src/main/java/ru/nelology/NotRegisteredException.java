package ru.nelology;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name){
        super("Player " + name + "isn't exist");
    }
}
