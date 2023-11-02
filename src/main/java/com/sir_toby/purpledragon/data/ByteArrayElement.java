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

package com.sir_toby.purpledragon.data;

import java.util.HexFormat;

public class ByteArrayElement extends Element
{
    private static final int lineLength = 95;

    private final byte[] byteArray;

    public ByteArrayElement( byte[] byteArray )
    {
        if ( byteArray == null ) throw new NullPointerException( "The \"byteArray\" parameter cannot be null." );

        this.byteArray = byteArray;
    }

    public String toString( String prefix )
    {
        StringBuilder builder = new StringBuilder();
        builder.append( prefix );
        builder.append( "[" );

        String hexString = HexFormat.ofDelimiter( " " ).formatHex( this.byteArray );

        if ( byteArray.length > 32 )
        {
            builder.append( System.lineSeparator() );
            builder.append( prefix );

            while ( hexString.length() > 0 )
            {
                String lineString = hexString.length() <= ByteArrayElement.lineLength ?
                        hexString : hexString.substring( 0, ByteArrayElement.lineLength );

                builder.append( "    " );
                builder.append( lineString );
                builder.append( System.lineSeparator() );
                builder.append( prefix );

                hexString = hexString.length() <= ByteArrayElement.lineLength ?
                        "" : hexString.substring( ByteArrayElement.lineLength + 1 );
            }
        }
        else
        {
            if ( this.byteArray.length > 0 ) builder.append( " " );
            builder.append( hexString );
            if ( this.byteArray.length > 0 ) builder.append( " " );
        }

        builder.append( "]" );
        builder.append( System.lineSeparator() );
        return builder.toString();
    }
}
