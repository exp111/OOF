package com.company;

import junit.framework.TestCase;

public class BenutzerVerwaltungAdminTest extends TestCase
{
    Benutzer user1;
    BenutzerVerwaltungAdmin admin;

    public BenutzerVerwaltungAdminTest()
    {
        super();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        user1 = new Benutzer("user1", "pw".toCharArray());
        admin = new BenutzerVerwaltungAdmin();
        admin.dbInitialisieren();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

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