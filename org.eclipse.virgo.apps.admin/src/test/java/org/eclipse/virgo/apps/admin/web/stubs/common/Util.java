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
package org.eclipse.virgo.apps.admin.web.stubs.common;

import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.ScriptableObject;

/**
 * 
 *
 */
public class Util {

	private final ScriptableObject SCOPE;
	
	private boolean pageReady = false;
	
	public static int fxTime = 200;
	
	public Util(ScriptableObject SCOPE) {
		this.SCOPE = SCOPE;
	}
	
	// Stub methods

	public void pageReady(){
		this.pageReady = true;
	}
	
	public Object getCurrentHost(){
		return Context.javaToJS("hostPrefix", SCOPE);
	}
	
	public Object readObjectName(Object mbean){
		return mbean;	
	}
	
	public void loadScript(Object scriptName, Object async){
		
	}
	
	// Test methods
	
	public boolean isPageReady(){
		return pageReady;
	}
	
}
