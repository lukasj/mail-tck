/*
 * Copyright (c) 2002, 2020 Oracle and/or its affiliates. All rights reserved.
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

package javasoft.sqe.tests.jakarta.mail.FetchProfile;

import java.util.*;
import java.io.*;
import jakarta.mail.*;
import com.sun.javatest.*;
import javasoft.sqe.tests.jakarta.mail.util.MailTest;

/**
 * This class tests the <strong>FetchProfile()</strong> API.
 * It does this by passing various valid input values and then checking
 * the type of the returned object.	<p>
 *
 *	    Create an empty FetchProfile. <p>
 * api2test: public FetchProfile()  <p>
 *
 * how2test: Call this constructor, verify the type of object created to be that of
 *	     FetchProfile. If so then this testcase passes, otherwise it fails.
 */

public class fetchProfile_Test extends MailTest {

    public static void main( String argv[] )
    {
        fetchProfile_Test test = new fetchProfile_Test();
        Status s = test.run(argv, System.err, System.out);
	s.exit();
    }

    public Status run(String argv[], PrintWriter log, PrintWriter out)
    {
	super.run(argv, log, out);
	parseArgs(argv);	// parse command-line options

        out.println("\nTesting class FetchProfile: FetchProfile(void)\n");

        try {
	   // BEGIN UNIT TEST 1:
	      out.println("UNIT TEST 1:  FetchProfile()");
	     
	      FetchProfile fp = new FetchProfile();	    // API TEST
	     
	      if( fp != null )
		  out.println("UNIT TEST 1: passed\n");
	      else {
		    out.println("UNIT TEST 1: FAILED\n");
		    errors++;
	      }
	   // END UNIT TEST 1:

              checkStatus();

        } catch ( Exception e ) {
              handlException(e);
        }
	return status;
     }
}
