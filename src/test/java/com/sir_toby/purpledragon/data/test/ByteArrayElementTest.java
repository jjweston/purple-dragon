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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ByteArrayElementTest
{
    @Test
    public void toString_empty()
    {
        byte[] input = {};
        String prefix = "    ";
        String expected = "    []" + System.lineSeparator();
        ByteArrayElement byteArrayElement = new ByteArrayElement( input );
        Assertions.assertEquals( expected, byteArrayElement.toString( prefix ), "Unexpected toString() result." );
    }

    @Test
    public void toString_short()
    {
        byte[] input =
        {
            -124, -70, -36, 15, 3, 32, -22, 31, -37, -33, 26, 78, 5, -75, -89, 46,
            -27, 123, -100, 79, 32, 80, -20, 72, -28, 1, 5, -8, 88, -13, -18, -53
        };

        String prefix = "        ";
        String expected = "        [ 84 ba dc 0f 03 20 ea 1f db df 1a 4e 05 b5 a7 2e " +
                                    "e5 7b 9c 4f 20 50 ec 48 e4 01 05 f8 58 f3 ee cb ]" +
                          System.lineSeparator();

        ByteArrayElement byteArrayElement = new ByteArrayElement( input );
        Assertions.assertEquals( expected, byteArrayElement.toString( prefix ), "Unexpected toString() result." );
    }

    @Test
    public void toString_long()
    {
        byte[] input =
        {
            -53, 13, 83, 35, -45, -89, -4, -35, 72, 86, -4, -24, -115, 13, -83, -26,
            -65, 108, -79, -105, 10, -111, -114, -124, -14, -16, -70, 8, -51, -64, 14, 50,
            6, -20, -59, 88, -20, -74, -54, -14, -95, -113, 12, -98, 4, -106, 60, 49,
            89, 83, 79, 94, -115, -23, 28, -112, -15, -101, -77, -23, -42, -34, 103, -82
        };

        String prefix = "            ";
        String expected = "            [" +
                          System.lineSeparator() +
                          "                cb 0d 53 23 d3 a7 fc dd 48 56 fc e8 8d 0d ad e6 " +
                                          "bf 6c b1 97 0a 91 8e 84 f2 f0 ba 08 cd c0 0e 32" +
                          System.lineSeparator() +
                          "                06 ec c5 58 ec b6 ca f2 a1 8f 0c 9e 04 96 3c 31 " +
                                          "59 53 4f 5e 8d e9 1c 90 f1 9b b3 e9 d6 de 67 ae" +
                          System.lineSeparator() +
                          "            ]" +
                          System.lineSeparator();

        ByteArrayElement byteArrayElement = new ByteArrayElement( input );
        Assertions.assertEquals( expected, byteArrayElement.toString( prefix ), "Unexpected toString() result." );
    }
}
