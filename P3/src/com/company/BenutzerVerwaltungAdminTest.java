package com.company;

import junit.framework.TestCase;

/*
* Tested die BenutzerVerwaltungAdmin Klasse
 */
public class BenutzerVerwaltungAdminTest extends TestCase
{
    Benutzer user1;
    BenutzerVerwaltungAdmin admin;

    public BenutzerVerwaltungAdminTest()
    {
        super();
    }

    /*
    * Initiaisiert einen Benutzer user1 und ein BenutzerVerwaltungAdmin admin
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        user1 = new Benutzer("user1", "pw".toCharArray());
        admin = new BenutzerVerwaltungAdmin();
        admin.dbInitialisieren();
    }

    /*
    * Löscht die Klassen wieder
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /*
    * Testet die BenutzerEintragen Funktion und catched BenutzerAlreadyExistsException
     */
    public void testBenutzerEintragen() {
        try
        {
            admin.benutzerEintragen(user1);
        }
        catch (BenutzerAlreadyExistsException e)
        {
            fail("Shouldn't exist");
        }

        try
        {
            admin.benutzerEintragen(user1);
            fail("Should exist");
        }
        catch (BenutzerAlreadyExistsException e)
        {

        }
    }

    /*
    * Testet die BenutzerOk Funktion
     */
    public void testBenutzerOk()
    {
        assertFalse(admin.benutzerOk(user1));
        try
        {
            admin.benutzerEintragen(user1);
        }
        catch (BenutzerAlreadyExistsException e)
        {
            fail("Shouldn't exist");
        }

        assertTrue(admin.benutzerOk(user1));
    }

    /*
    * Testet die BenutzerLöschen Funktion und catched die BenutzerNotFoundException.
     */
    public void testBenutzerLöschen()
    {
        try
        {
            admin.benutzerEintragen(user1);
        }
        catch (BenutzerAlreadyExistsException e)
        {
            fail("Shouldn't exist");
        }

        assertTrue(admin.benutzerOk(user1));

        try
        {
            admin.benutzerLöschen(user1);
        }
        catch (BenutzerNotFoundException e)
        {
            fail("Should exist");
        }

        assertFalse(admin.benutzerOk(user1));
    }
}