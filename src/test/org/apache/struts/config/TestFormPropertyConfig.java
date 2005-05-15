/*
 * $Id$ 
 *
 * Copyright 1999-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.struts.config;

import junit.framework.TestCase;

/**
 * Unit tests for the <code>org.apache.struts.config.FormPropertyConfig</code> 
 * class.
 * 
 * @version $Rev$ $Date$
 */
public class TestFormPropertyConfig 
        extends TestCase {
    
    
    public void testBasicInherit() {
        FormPropertyConfig base = 
                new FormPropertyConfig("base", "java.lang.String[]", "", 10);
        
        FormPropertyConfig sub = new FormPropertyConfig();
        sub.setName("base");
        
        sub.inheritFrom(base);
        
        assertEquals("Type was not inherited", base.getType(), sub.getType());
        assertEquals("Initial is incorrect", 
                base.getInitial(), sub.getInitial());
        assertEquals("Size was not inherited", base.getSize(), sub.getSize());        
    }
    
    public void testInheritWithInitialOverride() {
        FormPropertyConfig base = 
                new FormPropertyConfig("base", "java.lang.String", "value");
        
        FormPropertyConfig sub = new FormPropertyConfig();
        sub.setName("base");
        String initial = "otherValue";
        sub.setInitial(initial);
        
        sub.inheritFrom(base);
        
        assertEquals("Type was not inherited", base.getType(), sub.getType());
        assertEquals("Initial is incorrect", 
                initial, sub.getInitial());
        assertEquals("Size is incorrect", base.getSize(), sub.getSize());        
    }
                
    public void testInheritWithTypeOverride() {
        FormPropertyConfig base = 
                new FormPropertyConfig("base", "java.lang.String", "");
        
        FormPropertyConfig sub = new FormPropertyConfig();
        sub.setName("base");
        sub.setType("java.lang.Integer");
        
        sub.inheritFrom(base);
        
        assertEquals("Type is incorrect", "java.lang.Integer", sub.getType());
        assertEquals("Initial is incorrect", 
                base.getInitial(), sub.getInitial());
        assertEquals("Size is incorrect", base.getSize(), sub.getSize());        
    }
    
    public void testInheritWithTypeOverride2() {
        FormPropertyConfig base = 
                new FormPropertyConfig("base", "java.lang.String", "");
        
        FormPropertyConfig sub = new FormPropertyConfig();
        sub.setName("base");
        String type = "java.lang.Integer[]";
        int size = 10;
        sub.setType(type);
        sub.setSize(size);
        
        sub.inheritFrom(base);
        
        assertEquals("Type is incorrect", type, sub.getType());
        assertEquals("Initial is incorrect", 
                base.getInitial(), sub.getInitial());
        assertEquals("Size is incorrect", size, sub.getSize());        
    }
    
    public void testInheritWithSizeOverride() {
        FormPropertyConfig base = 
                new FormPropertyConfig("base", "java.lang.String[]", "", 20);
        
        FormPropertyConfig sub = new FormPropertyConfig();
        sub.setName("base");
        int size = 50;
        sub.setSize(size);
        
        sub.inheritFrom(base);
        
        assertEquals("Type was not inherited", base.getType(), sub.getType());
        assertEquals("Initial is incorrect", 
                base.getInitial(), sub.getInitial());
        assertEquals("Size is incorrect", size, sub.getSize());        
    }
    
}