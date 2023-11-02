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

public class StringElement extends Element
{
    private final String string;

    public StringElement( String string )
    {
        if ( string == null ) throw new NullPointerException( "The \"string\" parameter cannot be null." );

        this.string = string;
    }

    public String toString( String prefix )
    {
        StringBuilder builder = new StringBuilder();
        builder.append( prefix );
        builder.append( "\"" );

        for ( char c : this.string.toCharArray() )
        {
            switch ( c )
            {
                case '\t' : builder.append( "\\t"  ); break;
                case '\n' : builder.append( "\\n"  ); break;
                case '\r' : builder.append( "\\r"  ); break;
                case '\"' : builder.append( "\\\"" ); break;
                case '\\' : builder.append( "\\\\" ); break;
                default   : builder.append( c      ); break;
            }
        }

        builder.append( "\"" );
        builder.append( System.lineSeparator() );
        return builder.toString();
    }
}
