/*
 * Copyright (c) 2002, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javasoft.sqe.tests.javax.mail.Flags;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.javatest.*;
import javasoft.sqe.tests.javax.mail.util.MailTest;

/**
 * This class tests the <strong>add()</strong> API.
 * It does this by passing various valid input values and then checking
 * the type of the returned object.	<p>
 *
 *		Add all the flags in the given Flags object to this Flags object.<p>
 * api2test: public void add(Flags fo)  <p>
 *
 * how2test: Call the add() API with some specified Flags objects. The test is considered <p>
 *	     considered passing if the specified Flags object is present in this object.<p>
 *
 *
 *		Add the specified flag to this Flags object. <p>
 * api2test: public void add(String flag)  <p>
 *
 * how2test: Call the add(..) API with 'string' parameters. The test is considered <p>
 *	     passing if the specified Flags object is present in this object.
 */

public class add_Test extends MailTest {

    public static void main( String argv[] )
    {
        add_Test test = new add_Test();
        Status s = test.run(argv, System.err, System.out);
	s.exit();
    }

    public Status run(String argv[], PrintWriter log, PrintWriter out)
    {
	super.run(argv, log, out);
	parseArgs(argv);	// parse command-line options

        out.println("\nTesting class Flags: add(Flags | String)\n");

        try {
	  // BEGIN UNIT TEST 1:

	     out.println("\nUNIT TEST 1:  add(Flags)");

	     Flags flag1 = new Flags();

             if(( flag1 != null ) && ( flag1 instanceof Flags ))
	     {
		   flag1.add(Flags.Flag.DELETED);	// API TEST
		   flag1.add(Flags.Flag.SEEN);		// API TEST
		   flag1.add(Flags.Flag.RECENT);	// API TEST
		   flag1.add(Flags.Flag.ANSWERED);	// API TEST

		   if( flag1.contains(Flags.Flag.DELETED) )
			out.println("Flag DELETED added successfuly");
		   else
			errors++;

                   if( flag1.contains(Flags.Flag.SEEN) )
                       out.println("Flag SEEN added successfuly");
                   else
                       errors++;

                   if( flag1.contains(Flags.Flag.RECENT) )
                       out.println("Flag RECENT added successfuly");                
                   else
                       errors++;

                   if( flag1.contains(Flags.Flag.ANSWERED) )
                       out.println("Flag ANSWERED added successfuly");                
                   else
                       errors++;

		   if( errors == 0 )
                       out.println("UNIT TEST 1: passed\n");
		   else
			out.println("UNIT TEST 1: FAILED\n");
	     }
	     else {
		    out.println("UNIT TEST 1: FAILED\n");
		    errors++;
	     }
	  // END UNIT TEST 1:
          // BEGIN UNIT TEST 2:

             out.println("\nUNIT TEST 2: add(String)");

             Flags flag2 = new Flags(Flags.Flag.ANSWERED);

	     flag1.add("TEST_USER");	// API TEST
	     flag2.add("USER_TEST");	// API TEST

             if(( flag2 != null ) && ( flag2 instanceof Flags ))
	     {
                   if( flag1.contains("TEST_USER") )
                       out.println("Flag TEST_USER added successfuly");
                   else
                       errors++;

                   if( flag2.contains("USER_TEST") )
                       out.println("Flag USER_TEST added successfuly");
                   else
                       errors++;

                   if( errors == 0 )
                       out.println("UNIT TEST 2: passed\n");
                   else
                       out.println("UNIT TEST 2: FAILED\n");
	     }
             else {
                    out.println("UNIT TEST 2: FAILED\n");
                    errors++;
             }
          // END UNIT TEST 2:

	     checkStatus();

        } catch ( Exception e ) {
             handlException(e);
        }
	return status;
     }
}
