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

package com.sir_toby.purpledragon.data;

public class NodeAttribute
{
    private final Element name;
    private final Element value;

    public NodeAttribute( Element name, Element value )
    {
        this.name  = name;
        this.value = value;
    }

    public String toString()
    {
        return this.toString( "" );
    }

    public String toString( String prefix )
    {
        StringBuilder builder = new StringBuilder();
        builder.append( this.elementToString( this.name,  prefix ));
        builder.append( this.elementToString( this.value, prefix ));
        return builder.toString();
    }

    private String elementToString( Element element, String prefix )
    {
        StringBuilder builder = new StringBuilder();

        if ( element == null )
        {
            builder.append( prefix );
            builder.append( "null" );
            builder.append( System.lineSeparator() );
        }
        else builder.append( element.toString( prefix ));

        return builder.toString();
    }
}
