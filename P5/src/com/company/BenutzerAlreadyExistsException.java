package com.company;

public class BenutzerAlreadyExistsException extends Exception
{
    BenutzerAlreadyExistsException(String ex)
    {
        super(ex);
    }
}
