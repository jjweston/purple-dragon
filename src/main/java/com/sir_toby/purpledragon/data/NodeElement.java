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

public class NodeElement extends Element
{
    private final NodeAttribute[] nodeAttributes;

    public NodeElement( NodeAttribute[] nodeAttributes )
    {
        if ( nodeAttributes == null )
        {
            throw new NullPointerException( "The \"nodeAttributes\" parameter cannot be null." );
        }

        for ( NodeAttribute nodeAttribute : nodeAttributes ) if ( nodeAttribute == null )
        {
            throw new NullPointerException( "The \"nodeAttributes\" parameter cannot contain a null element." );
        }

        this.nodeAttributes = nodeAttributes;
    }

    public String toString( String prefix )
    {
        StringBuilder builder = new StringBuilder();

        builder.append( prefix );
        builder.append( "{" );

        for ( NodeAttribute nodeAttribute : this.nodeAttributes )
        {
            builder.append( System.lineSeparator() );
            builder.append( nodeAttribute.toString( prefix + "    " ));
        }

        if ( this.nodeAttributes.length > 0 ) builder.append( prefix );
        builder.append( "}" );
        builder.append( System.lineSeparator() );
        return builder.toString();
    }
}
