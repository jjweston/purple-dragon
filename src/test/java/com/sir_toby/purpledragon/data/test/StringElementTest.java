/*

purple-dragon : Experiment with language-oriented programming.

Copyright (C) 2023, Jeffrey J. Weston <jjweston@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/

package com.sir_toby.purpledragon.data.test;

import com.sir_toby.purpledragon.data.StringElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringElementTest
{
    @Test
    public void constructor_null()
    {
        Exception exception =
                Assertions.assertThrowsExactly( NullPointerException.class, () -> new StringElement( null ));

        Assertions.assertEquals( "The \"string\" parameter cannot be null.",
                                 exception.getMessage(), "Unexpected exception message." );
    }

    @Test
    public void toString_test()
    {
        String input = "tab: \t, linefeed: \n, carriage return: \r, double quote: \", backslash: \\";
        StringElement stringElement = new StringElement( input );

        String prefix = "    ";
        String expected = "    \"tab: \\t, linefeed: \\n, carriage return: \\r, " +
                          "double quote: \\\", backslash: \\\\\""                 + System.lineSeparator();

        Assertions.assertEquals( expected, stringElement.toString( prefix ), "Unexpected toString() result." );
    }
}
