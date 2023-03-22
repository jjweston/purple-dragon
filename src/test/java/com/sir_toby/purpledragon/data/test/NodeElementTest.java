/*

purple-dragon : Experiment with language-driven programming.

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

import com.sir_toby.purpledragon.data.ByteArrayElement;
import com.sir_toby.purpledragon.data.NodeAttribute;
import com.sir_toby.purpledragon.data.NodeElement;
import com.sir_toby.purpledragon.data.StringElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeElementTest
{
    @Test
    public void toString_empty()
    {
        NodeElement nodeElement = new NodeElement( new NodeAttribute[] {} );

        String prefix = "    ";
        String expected = "    {}" + System.lineSeparator();
        Assertions.assertEquals( expected, nodeElement.toString( prefix ), "Unexpected toString() result." );
    }

    @Test
    public void toString_complex()
    {
        byte[] byteArray =
        {
            -53, 13, 83, 35, -45, -89, -4, -35, 72, 86, -4, -24, -115, 13, -83, -26,
            -65, 108, -79, -105, 10, -111, -114, -124, -14, -16, -70, 8, -51, -64, 14, 50,
            6, -20, -59, 88, -20, -74, -54, -14, -95, -113, 12, -98, 4, -106, 60, 49,
            89, 83, 79, 94, -115, -23, 28, -112, -15, -101, -77, -23, -42, -34, 103, -82
        };

        ByteArrayElement byteArrayElement = new ByteArrayElement( byteArray );
        NodeAttribute byteArrayNodeAttribute = new NodeAttribute( new StringElement( "Byte Array" ), byteArrayElement );
        NodeElement childNodeElement = new NodeElement( new NodeAttribute[] { byteArrayNodeAttribute } );
        NodeElement emptyNodeElement = new NodeElement( new NodeAttribute[] {} );

        NodeAttribute stringNodeAttribute = new NodeAttribute( new StringElement( "name" ),
                                                               new StringElement( "value" ));
        NodeAttribute childNodeAttribute = new NodeAttribute( new StringElement( "Child Node" ), childNodeElement );
        NodeAttribute emptyNodeAttribute = new NodeAttribute( new StringElement( "Empty Node" ), emptyNodeElement );
        NodeElement nodeElement =
                new NodeElement( new NodeAttribute[] { stringNodeAttribute, childNodeAttribute, emptyNodeAttribute } );

        String prefix = "        ";
        String expected =
                "        {"                                                            + System.lineSeparator() +
                "            \"name\""                                                 + System.lineSeparator() +
                "            \"value\""                                                + System.lineSeparator() +
                                                                                         System.lineSeparator() +
                "            \"Child Node\""                                           + System.lineSeparator() +
                "            {"                                                        + System.lineSeparator() +
                "                \"Byte Array\""                                       + System.lineSeparator() +
                "                ["                                                    + System.lineSeparator() +
                "                    cb 0d 53 23 d3 a7 fc dd 48 56 fc e8 8d 0d ad e6 " +
                                    "bf 6c b1 97 0a 91 8e 84 f2 f0 ba 08 cd c0 0e 32"  + System.lineSeparator() +
                "                    06 ec c5 58 ec b6 ca f2 a1 8f 0c 9e 04 96 3c 31 " +
                                    "59 53 4f 5e 8d e9 1c 90 f1 9b b3 e9 d6 de 67 ae"  + System.lineSeparator() +
                "                ]"                                                    + System.lineSeparator() +
                "            }"                                                        + System.lineSeparator() +
                                                                                         System.lineSeparator() +
                "            \"Empty Node\""                                           + System.lineSeparator() +
                "            {}"                                                       + System.lineSeparator() +
                "        }"                                                            + System.lineSeparator();

        Assertions.assertEquals( expected, nodeElement.toString( prefix ), "Unexpected toString() result." );
    }
}
