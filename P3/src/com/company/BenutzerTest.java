package com.company;

import junit.framework.TestCase;
import org.junit.Test;

/*
* Tested die Benutzer Klasse.
 */
public class BenutzerTest extends TestCase
{
    Benutzer user1;
    Benutzer user2;
    Benutzer user3;
    Benutzer user4;

    public BenutzerTest()
    {
        super();
    }

    /*
    * Initialisiert die Benutzer user1, user2, user3, user4.
    * user1 == user3
    * user4 equals user1
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        user1 = new Benutzer("user1", "pw".toCharArray());
        user2 = new Benutzer("user2", "anotherpw".toCharArray());
        user3 = user1;
        user4 = new Benutzer(user1);
    }

    /*
    * Löscht die Benutzer wieder
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /*
    * Testet die Konstruktoren
     */
    public void testConstructor()
    {
        assertSame(user1, user3);
        assertNotSame(user1, user2);
        assertNotSame(user1, user4);
    }

    /*
    * Testet die überschriebende Equals Funktion
     */
    public void testEquals() {
        assertFalse(user1.equals(user2));
        assertTrue(user1.equals(user3));
        assertTrue(user1.equals(user4));
        assertSame(user1, user3);
        assertNotSame(user1, user4);
    }

    /*
    * Tested die überschrieben ToString Funktion
     */
    public void testToString() {
        assertEquals(user1.toString(), "(Benutzer, ID: user1, PW: [p, w])");
    }
}