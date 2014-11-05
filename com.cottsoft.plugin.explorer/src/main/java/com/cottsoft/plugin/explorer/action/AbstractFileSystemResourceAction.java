/*
 * Copyright 2005-2014 the original author or authors.
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
 * 
 * Author:	Simon.Hoo
 * Blog:   	http://www.cottsoft.com 
 * Email:	Info@cottsoft.com
 * 
 * You can @simonhoo  on Github.com, weibo.com, twitter, t.qq.com
 */

package com.cottsoft.plugin.explorer.action;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * Description：<br> 
 * 抽象Action, 得到当前目录的URL,然后交给具体执行的方法
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    Nov 5, 2014
 * @version v1.0.0
 */
public abstract class AbstractFileSystemResourceAction extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);  
	        ISelection selection = window.getSelectionService().getSelection();  
	        if (selection instanceof IStructuredSelection) {  
	            Object element = ((IStructuredSelection) selection).getFirstElement();  
	            IResource resource = null;  
	            if ((element instanceof IResource)) {  
	                resource = (IResource) element;  
	            } else if (element instanceof IAdaptable) {  
	                resource = (IResource) ((IAdaptable) element) .getAdapter(IResource.class);  
	            }   
	            if(resource != null) {  
	                doExecute(resource.getLocation().toFile());  
	            }  
	        }  
	        return null;
	}

	protected abstract void doExecute(File file);  
}


