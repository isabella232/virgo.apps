/*******************************************************************************
 * Copyright (c) 2008, 2011 VMware Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   VMware Inc. - initial contribution
 *******************************************************************************/
package org.eclipse.virgo.apps.admin.web.stubs.objects;

import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.Function;
import sun.org.mozilla.javascript.internal.Scriptable;
import sun.org.mozilla.javascript.internal.ScriptableObject;

/**
 * 
 *
 */
public class Util {

    private final Context context;
    
	private final ScriptableObject SCOPE;
	
	private boolean pageReady = false;

    private String[] lastMakeTableRows;

    private String[] lastMakeTableHeaders;

    private Scriptable lastMakeTableTable;

	public static int fxTime = 200;
	
	public Util(Context context, ScriptableObject SCOPE) {
	    this.context = context;
		this.SCOPE = SCOPE;
	}
	
	// Stub methods

	public void pageReady(){
		this.pageReady = true;
	}
	
	public Object getCurrentHost(){
		return Context.javaToJS("hostPrefix", SCOPE);
	}
	
	
	public Object readObjectName(String mbeanName){
		return new MBean(mbeanName);	
	}
	
	public void loadScript(Object scriptName, Object async){
		
	}
	
	public Object makeTable(Scriptable properties) {
	    this.lastMakeTableHeaders = (String[]) Context.jsToJava(ScriptableObject.getProperty(properties, "headers"), String[].class);
	    this.lastMakeTableRows = (String[]) Context.jsToJava(ScriptableObject.getProperty(properties, "rows"), String[].class);

	    Function elementConstructor = (Function) SCOPE.get("Element", SCOPE);
        Object[] args = new Object[]{properties};
        Scriptable table = elementConstructor.construct(Context.getCurrentContext(), SCOPE, args);
        this.lastMakeTableTable = table;
        return table;
	}
	
	public Object makeDiv(String clazz) {
	    Function elementConstructor = (Function) SCOPE.get("Element", SCOPE);
        Object[] args = new Object[]{clazz};
        return elementConstructor.construct(this.context, SCOPE, args);
	}
	
	// Test methods
	
	public boolean isPageReady(){
		return pageReady;
	}
	
	public String[] getLastMakeTableHeaders() {
	    return this.lastMakeTableHeaders;
	}
	
	public String[] getLastMakeTableRows() {
	    return this.lastMakeTableRows;
	}
	
	public Scriptable getLastMakeTableTable() {
	    return this.lastMakeTableTable;
	}
	
}
